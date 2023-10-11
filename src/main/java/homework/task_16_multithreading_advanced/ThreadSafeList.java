package homework.task_16_multithreading_advanced;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeList<T> { // клас ThreadSafeList є параметризованим типом (дженериком).
    // Це означає, що можна використовувати цей клас для зберігання об'єктів будь-якого типу.

    private Queue<T> queue = new LinkedList<>(); //для зберігання запитів на заправку

    private ReentrantLock lock = new ReentrantLock(); // це об'єкт типу ReentrantLock, який буде використовуватися для
    // синхронізації доступу до черги в багатопоточному середовищі.
    // (забезпечення безпечного доступу до черги в багатопоточному середовищі. Це допомагає уникнути гонок потоків.)

    public void add(T item){
        lock.lock(); // використовуємо замок для заблокування доступу до черги.
        try {
            queue.add(item);
        } finally {
            lock.unlock(); //блок забезпечує вивільнення замку після виконання операції додавання.
        }
    }

    public T remove(){
        lock.lock();
        try {
            return queue.poll();
        } finally {
            lock.unlock();
        }

    }
    //повертає поточну кількість пального на станції.
    public T get(){
        lock.lock();
        try {
            return queue.peek();
        } finally {
            lock.unlock();
        }

    }

}
