package ru.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders1")
public class Order {
    @Id
    @Column(name = "orderDate")
    public String orderDate;

    public Order() {}

    public Order(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderDate='" + orderDate + '\'' +
                '}';
    }
}
