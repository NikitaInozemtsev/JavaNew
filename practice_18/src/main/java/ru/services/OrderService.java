package ru.services;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.model.Item;
import ru.model.Order;
import ru.repositories.OrderRepository;


import java.util.List;

@Service
public class OrderService {

    private  OrderRepository reps;

    public OrderService(OrderRepository reps) {
        this.reps = reps;
    }

    public List<Order> getOrders() {
        return reps.findAll();
    }

    public void insertOrder(Order a) {
        reps.save(a);

    }

    public void deleteOrder(Order a) {
        reps.delete(a);
    }

    public Item getItemsByOrder(String orderDate) {
        return reps.findById(orderDate).get().getItem();
    }

    public List<Order> orderByOrderDate() {
        return reps.findAll(Sort.by("orderDate"));
    }

    public List<Order> orderByItemName() {
        return reps.findAll(Sort.by("itemName"));
    }
}
