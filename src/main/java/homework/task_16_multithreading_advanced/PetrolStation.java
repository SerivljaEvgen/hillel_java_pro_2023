package homework.task_16_multithreading_advanced;

public class PetrolStation {

    private int amount; //кількість пального на станції.
    private ThreadSafeList<Integer> refuelRequest = new ThreadSafeList<>();

    public PetrolStation(int amount) {
        this.amount = amount;
    }

    public void doRefuel (int fuelAmount){
        //Перевіряється, чи передана кількість пального більше нуля, і якщо так, то запит додається до черги refuelRequests.
        if(fuelAmount > 0) {
            //додаємо запит на заправку в чергу
            refuelRequest.add(fuelAmount);
            //Якщо поточний запит є першим у черзі (серед всіх одночасних запитів), то розпочинається операція заправки
            if(refuelRequest.get() == fuelAmount) {
                // Only the first request will attempt to refuel
                // Генерується випадковий час заправки від 3 до 10 секунд, щоб симулювати тривалість заправки.
                int timeToRefuel = 3 + (int) (Math.random() * 8);
                try {
                    //Засинаємо потік (використовуючи Thread.sleep) для симуляції тривалості заправки.
                    Thread.sleep(timeToRefuel * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Після закінчення заправки видаляємо запит з черги.
                refuelRequest.remove();
                //Використовуємо synchronized блок для захисту від багатопоточного доступу до amount (кількість пального на станції).
                synchronized (this) {
                    //Якщо на станції достатньо пального для заправки, відбувається віднімання кількості пального на станції
                    // та виведення повідомлення про успішну заправку. У іншому випадку виводиться повідомлення про недостатність пального.
                    if (amount >= fuelAmount) {
                        amount -= fuelAmount;
                        System.out.println("Successfully refueled " + fuelAmount + " liters.");
                    } else {
                        System.out.println("Not enough fuel in the station.");
                    }
                }
            }
        }
    }

    public int getAmount() {
        return amount;
    }
}
