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
    public void deliver() {
        System.out.println("The closest in the order queue: \n" +
                queueOrderList.poll());
    }

    //3
    public void deliver(Order deliverOrder) {
        List<Order> listOrderList = new ArrayList<>(queueOrderList);
        System.out.println("Delivered specific order: " + deliverOrder.getOrderNum());
        listOrderList.remove(deliverOrder);
        queueOrderList.clear();
        queueOrderList.addAll(listOrderList);
    }

    //4
    public void draw() {
        for (Order order : queueOrderList) {
            System.out.println(order.getOrderNum() + "|" + order.getCustomerName());
        }
    }
}
