package homework.task_16_multithreading_advanced;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int maxRequests = 4;
        PetrolStation petrolStation = new PetrolStation(100, maxRequests);


        ExecutorService executor = Executors.newFixedThreadPool(maxRequests); // Створюємо пул потоків з розміром 4.

        // Використовуємо ExecutorService для запуску потоків замість створення окремих потоків.
        executor.submit(() -> petrolStation.doRefuel(30));
        executor.submit(() -> petrolStation.doRefuel(20));
        executor.submit(() -> petrolStation.doRefuel(15));
        executor.submit(() -> petrolStation.doRefuel(10));

        // Зупиняємо ExecutorService.
        executor.shutdown();

        // Очікуємо завершення всіх потоків у пулі.
        while (!executor.isTerminated()) { //Цей метод перевіряє, чи всі завдання, запущені в пулі потоків,
            // вже завершили своє виконання. Він повертає true, якщо всі завдання в пулі були виконані та пул був
            // коректно закритий, і false в іншому випадку.
            Thread.yield(); //Цей метод вказує поточному потоку уступити процесор і дати можливість іншим потокам
            // виконати деякі операції. В даному випадку він викликається в циклі, який очікує завершення всіх потоків.
            //Використовуючи Thread.yield(), ми намагаємося зменшити навантаження на процесор, дозволяючи іншим потокам виконати роботу.

        }
        //    Цикл while (!executor.isTerminated()) буде виконуватися до тих пір, поки executor.isTerminated() не поверне true. Тобто, цей цикл продовжується, доки всі завдання в пулі не завершать виконання.
        //
        //Отже, дана конструкція очікує завершення всіх потоків, які були запущені з використанням ExecutorService, і
        // це дозволяє головному потоку продовжити свою роботу тільки після того, як всі інші потоки завершать свою роботу.

        System.out.println("Remaining fuel on the station: " + petrolStation.getAmount() + " liters.");
    }
}
