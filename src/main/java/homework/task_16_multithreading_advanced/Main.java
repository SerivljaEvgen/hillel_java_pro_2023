package homework.task_16_multithreading_advanced;

public class Main {
    public static void main(String[] args) {

        PetrolStation petrolStation = new PetrolStation(100);

        Thread car1 = new Thread(()-> petrolStation.doRefuel(30));

        Thread car2 = new Thread(()-> petrolStation.doRefuel(20));

        Thread car3 = new Thread(()-> petrolStation.doRefuel(10));

        car1.start();
        car2.start();
        car3.start();

        // Очікуємо завершення всіх потоків.
        //очікуємо, поки всі 3 потоки (car1, car2, car3) завершать запити на заправку до станції,
        // перед тим як перейти до наступних дій. Це забезпечує правильний порядок виводу і відображення результатів роботи програми.
        // Якщо не використовувати join, то головний потік може продовжити виконувати інструкції, навіть якщо інші потоки
        // ще не завершили роботу, і це може призвести до некоректних результатів або виведення інформації в неправильному порядку.
        try {
            car1.join();
            car2.join();
            car3.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Remaining fuel on the station: " + petrolStation.getAmount() + " liters.");

    }
}
