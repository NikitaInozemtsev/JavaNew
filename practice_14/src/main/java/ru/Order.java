package ru;

public class Order implements AllFunc{
    public String orderDate;

    public Order(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate='" + orderDate + '\'' +
                '}';
    }
}
