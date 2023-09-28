package homework.task_13_queue.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    private final Queue<Order> queueOrderList = new LinkedList<>();
    private int nextOrderNumber = 1;

    //1
    public void add(Order order) {
        order.setOrderNum(nextOrderNumber);
        queueOrderList.add(order);
        nextOrderNumber++;
    }

    //2
    public Order deliver() {
        System.out.println("The closest in the order queue: ");
        return queueOrderList.poll();
    }

    //3
    public Order deliver(int orderNum) {
        System.out.println("Delivered specific order: ");
        for (Order order : queueOrderList) {
            if (order.getOrderNum() == orderNum) {
                queueOrderList.remove(order);
                return order;
            }
        }
        System.out.println("specific order: " + orderNum + " not found");
        return null;
    }

    //4
    public void draw() {
        for (Order order : queueOrderList) {
            System.out.println(order.getOrderNum() + "|" + order.getCustomerName());
        }
    }
}
