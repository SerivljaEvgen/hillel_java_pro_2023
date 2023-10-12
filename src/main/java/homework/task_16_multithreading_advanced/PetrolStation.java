package homework.task_16_multithreading_advanced;

import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {

    private final AtomicInteger amount; //представляє кількість пального на станції і атомарно оновлюється в різних потоках.
    private final int maxConcurrentRefuels = 3; //максимальна кількість одночасних запитів на заправку.
    private AtomicInteger[] refuelRequests; //це масив AtomicInteger, де зберігаються запити на заправку. Величина масиву обмежена maxConcurrentRefuels.
    private int requestIndex;

    //Конструктор PetrolStation приймає початкову кількість пального і максимальну кількість запитів на заправку та ініціалізує відповідні поля об'єкта.
    public PetrolStation(int initialAmount, int maxRequests) {
        this.amount = new AtomicInteger(initialAmount);
        this.refuelRequests = new AtomicInteger[maxRequests];
        this.requestIndex = 0;
    }

    //Метод doRefuel приймає кількість пального, яку автомобіль хоче заправити. Якщо запит на заправку дійсний
    // (кількість пального більше 0), і є місце для ще одного одночасного запиту (якщо requestIndex менше maxConcurrentRefuels), то:
    //    Створюється новий об'єкт AtomicInteger у refuelRequests з вказаною кількістю пального.
    //    Записується індекс поточного запиту в currentIndex і збільшується requestIndex.
    //    Генерується випадковий час заправки (від 3 до 10 секунд) і потік "засинає" на цей час, симулюючи заправку.
    //    Після закінчення заправки перевіряється, чи на станції є достатньо пального для заправки refuelRequests[currentIndex].get(). Якщо так, то кількість пального в станції атомарно зменшується на цю кількість, і виводиться повідомлення про успішну заправку. Якщо недостатньо пального, виводиться повідомлення про відсутність пального.
    public void doRefuel(int fuelAmount) {
        if (fuelAmount > 0) {
            if (requestIndex < maxConcurrentRefuels) {
                refuelRequests[requestIndex] = new AtomicInteger(fuelAmount);
                int currentIndex = requestIndex;
                requestIndex++;

                int timeToRefuel = 3 + (int) (Math.random() * 8);
                try {
                    Thread.sleep(timeToRefuel * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (amount.get() >= refuelRequests[currentIndex].get()) {
                    amount.addAndGet(-refuelRequests[currentIndex].get());
                    System.out.println("Successfully refueled " + refuelRequests[currentIndex].get() + " liters.");
                } else {
                    System.out.println("Not enough fuel in the station.");
                }
            }
        }
    }

    public int getAmount() {
        return amount.get();
    }
}
