package homework.task_22_testing;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DataStorageTest {
    private static final String TEST_FILE_PATH = "testDataBase.txt";


    @Test
    public void testInMemoryStorage(){
        DataStorage<String> dataStorage = new InMemoryStorage<>();
        dataStorage.save("Test data in memory");
        String loadedData = dataStorage.load();
        assertEquals("Test data in memory", loadedData);
    }

    @Test
    public void testDatabaseStorageWithMock(){
        // Створення моків для інтерфейсу DataStorage
        // Тут створюється об'єкт-мок (mock), який є підставною реалізацією інтерфейсу DataStorage. Моки використовуються
        // для тестування, коли вам потрібно емулювати поведінку об'єктів.
        DataStorage<String> mockDataStorage = Mockito.mock(DataStorage.class);

        // Створення об'єкту DatabaseStorage з мокованою залежністю
        DatabaseStorage<String> databaseStorage = new DatabaseStorage<>();

        // Тестування методів load() та save()
        String testData = "Test data";
        databaseStorage.save(testData);
        //За допомогою when(...).thenReturn(...) налаштовуємо мок так, щоб при виклику методу load() поверталася тестова дата.
        when(mockDataStorage.load()).thenReturn(testData);

        // Перевірка, чи дані збереглися та можуть бути завантажені
        databaseStorage.save(testData);
        String loadedData = databaseStorage.load();

        // Перевірка результату
        assertEquals(testData, loadedData);
    }

    @Test
    public void testFileStorage() {
        FileStorage<String> fileStorage = new FileStorage<>(TEST_FILE_PATH);
        String testData = "Test data";

        // Act
        fileStorage.save(testData);
        String loadedData = fileStorage.load();

        // Assert
        assertEquals(testData, loadedData);
    }


}
