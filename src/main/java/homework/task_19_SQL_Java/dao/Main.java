package homework.task_19_SQL_Java.dao;

import homework.task_19_SQL_Java.DataBaseConnection;
import homework.task_19_SQL_Java.dto.Lesson;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        //1 Створення екземпляра класу DataBaseConnection для підключення до бази даних
        DataBaseConnection connection = new DataBaseConnection("jdbc:mysql://localhost:3306/hillel_2023","root", "******3787");

        // 2 Створення екземпляра класу LessonDao
        LessonDao lessonDao = new LessonDao(connection.getConnection());

        //3 Додавання нового уроку
        Lesson newLesson = new Lesson();
        newLesson.setName("Java Pro");
        lessonDao.addLesson(newLesson);

        Lesson newLesson2 = new Lesson();
        newLesson2.setName("Java Basics");
        lessonDao.addLesson(newLesson2);

        //4 Отримання уроку за ID
        int lessonId = 2;
        Lesson retrievedLesson = lessonDao.getLessonById(lessonId);
        if (retrievedLesson != null) {
            System.out.println("ID " + lessonId + ": " + retrievedLesson.getName());
        } else {
            System.out.println("ID " + lessonId + " not found");
        }

        //5 Видалення уроку за ID
       // lessonDao.deleteLesson(lessonId);
        System.out.println("Lesson with ID " + lessonId + " has been deleted");

        //6 Отримання всіх уроків з бази даних
        List<Lesson> allLessons = lessonDao.getAllLessons();
        System.out.println("All lessons: ");
        for (Lesson lesson: allLessons) {
            System.out.println( );
            System.out.println(lesson.getId() + ": " + lesson.getName());
        }

        // 7. Закриття з'єднання з базою даних
        connection.close(connection.getConnection());


    }
}
