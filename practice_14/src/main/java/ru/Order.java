package ru;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order implements AllFunc{
    @JsonProperty("orderDate")
    public String orderDate;

    public Order() {}

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

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
