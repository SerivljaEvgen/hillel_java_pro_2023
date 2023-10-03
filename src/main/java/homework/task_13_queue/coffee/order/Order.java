package homework.task_13_queue.coffee.order;


public class Order {
    private int orderNum;
    private final String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    @Override
    public String toString() {
        return
                orderNum +
                        "|" + customerName;
    }
}
