package ru.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Order;

/**
 * Service for interacting with order
 */
@Service
public class OrderService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public OrderService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * Initializing session
     */
    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    /**
     * Closing session
     */
    @PreDestroy
    void closeSession() {
        session.close();
    }

    /**
     * Get orders from DB
     *
     * @return All our orders in DB
     */
    public List<Order> getOrders() {
        return session.createQuery("select o from Order o", Order.class).getResultList();
    }

    /**
     * Save order in DB
     *
     * @param a order to save
     */
    public void insertOrder(Order a) {
        session.beginTransaction();
        Order employee = session.get(Order.class, a.getOrderDate());
        if (employee == null) {
            session.save(a);
        }
        session.getTransaction().commit();
    }

    /**
     * Delete order from DB if exist
     *
     * @param a order to delete
     */
    public void deleteOrder(Order a) {
        session.beginTransaction();
        Order employee = session.get(Order.class, a.getOrderDate());
        if (employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
    }
}
