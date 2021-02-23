package ru.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Item;
import ru.model.Order;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public OrderService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    @PreDestroy
    void closeSession() {
        session.close();
    }

    public List<Order> getOrders() {
        return session.createQuery("select o from Order o", Order.class).getResultList();
    }

    public void insertOrder(Order a) {
        session.beginTransaction();
        Order employee = session.get(Order.class, a.getOrderDate());
        if(employee == null) {
            session.save(a);
        }
        session.getTransaction().commit();
    }

    public void deleteOrder(Order a) {
        session.beginTransaction();
        Order employee = session.get(Order.class, a.getOrderDate());
        if(employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
    }

    public Item getItemsByOrder(String orderDate) {
        return session.createQuery("from Order where order_date =:order_date", Order.class)
                .setParameter("order_date", orderDate).getSingleResult().getItem();
    }
}
