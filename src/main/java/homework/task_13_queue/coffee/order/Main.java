package homework.task_13_queue.coffee.order;

public class Main {
    public static void main(String[] args) {

        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        //1 - add
        Order order1 = new Order("Alice");
        Order order2 = new Order("Tom");
        Order order3 = new Order("Mel");
        Order order4 = new Order("John");
        Order order5 = new Order("Max");

        orderBoard.add(order1);
        orderBoard.add(order2);
        orderBoard.add(order3);
        orderBoard.add(order4);
        orderBoard.add(order5);

        System.out.println("\"Coffee Orders\"after add");
        // 4 - draw
        orderBoard.draw();
        System.out.println("-----------------");

        //2 - deliver
        orderBoard.deliver();
        System.out.println("\"Coffee Orders\" after deliver");
        // 4 - draw
        orderBoard.draw();
        System.out.println("-----------------");

        //3 - deliver with specific order
        orderBoard.deliver(order3);
        System.out.println("\"Coffee Orders\" after deliver specific order");
        // 4 - draw
        orderBoard.draw();
        System.out.println("-----------------");

    }

}

