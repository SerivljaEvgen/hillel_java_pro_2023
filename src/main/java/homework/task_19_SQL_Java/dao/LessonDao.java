package homework.task_19_SQL_Java.dao;

import homework.task_19_SQL_Java.dto.Lesson;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {
    private final Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    //1. Method for adding a lesson
    public void addLesson(Lesson lesson) {
        String sqlQuery = "INSERT INTO homework_19_sql.lesson (name) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery, Statement.RETURN_GENERATED_KEYS))
        //Statement.RETURN_GENERATED_KEYS це константа, яка вказує, що при виконанні SQL-запиту, який вставляє дані в таблицю
        // з автоматично згенерованим ключем (наприклад, автоінкрементним полем), необхідно повернути сгенеровані ключі.
        {
            //Встановлюється значення параметра ? в SQL-запиті. У цьому випадку це єдиний параметр, і ми встановлюємо його на основі name у переданому об'єкті lesson.
            statement.setString(1, lesson.getName()); // число "1" вказує на порядковий номер параметра у SQL-запиті, який має бути встановлений

            // Запускається виконання SQL-запиту statement.executeUpdate(), і результатом є кількість рядків, які були змінені/додані в таблиці.
            // Якщо affectedRows дорівнює 0, це означає, що додавання уроку не вдалось (наприклад, через помилку бази даних).
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to add lesson, no row was added.");
            }

            //дозволяє вам отримати згенеровані ключі після виконання запиту та використовувати їх для подальшої роботи з доданим записом в базі даних.
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) { //для переходу до першого рядка в наборі результатів
                    lesson.setId(generatedKeys.getInt(1)); // Встановлюємо ідентифікатор уроку
                } else {
                    throw new SQLException("Failed to add lesson, could not get ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while adding the lesson to the database");
        }
    }

    //2. Method to delete lesson by ID
    public void deleteLesson(int lessonId) {
        String sqlQuery = "DELETE FROM homework_19_sql.lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            //В SQL-запитах, де є багато параметрів (позначених як ?), ви повинні вказувати номер параметра,
            // який ви встановлюєте, щоб JDBC знало, який параметр вам потрібно встановити в порядку, в якому вони зустрічаються в SQL-запиті
            statement.setInt(1, lessonId);
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Failed to delete lesson");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while deleting the lesson from the database");
        }

    }

    //3. Method to get all lessons
    public List<Lesson> getAllLessons() {
        List<Lesson> lessons = new ArrayList<>();
        String sqlQuery = "SELECT * FROM homework_19_sql.lesson";

        try (PreparedStatement statement = connection.prepareStatement(sqlQuery);
             // ResultSet - це об'єкт, який використовується для отримання результатів запиту після його виконання.
             ResultSet resultSet = statement.executeQuery()) {

            //викликається для переходу до наступного рядка результатів. Цикл продовжується, доки є наступні рядки результатів.
            while (resultSet.next()) {
                Lesson lesson = new Lesson(); //створюєте об'єкт Lesson для кожного рядка результатів.
                lesson.setId(resultSet.getInt("id"));
                lesson.setName(resultSet.getString("name"));
                //Після створення об'єкта Lesson з даними з рядка результатів, цей об'єкт додається до списку lessons.
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("An error occurred while retrieving lessons from the database");
        }
        return lessons;
    }

    // 4. Method to get a lesson by ID
    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        String sqlQuery = "SELECT * FROM homework_19_sql.lesson WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlQuery)) {
            statement.setInt(1, lessonId);
            //Об'єкт ResultSet представляє результати SQL-запиту і дозволяє переглядати ці результати.
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    lesson = new Lesson();
                    lesson.setId(resultSet.getInt("id"));
                    lesson.setName(resultSet.getString("name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving lesson by ID from database");
        }
        return lesson;
    }

}
