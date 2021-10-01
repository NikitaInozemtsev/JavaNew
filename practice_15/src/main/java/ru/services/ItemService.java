package ru.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Item;

/**
 * Service for interacting with item
 */
@Service
public class ItemService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public ItemService(SessionFactory sessionFactory) {
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
     * Get items from DB
     *
     * @return All our items in DB
     */
    public List<Item> getItems() {
        return session.createQuery("select i from Item i", Item.class).getResultList();
    }

    /**
     * Save item in DB
     *
     * @param a item to save
     */
    public void insertItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if (employee == null) {
            session.save(a);
        }
        session.getTransaction().commit();
    }

    /**
     * Delete item from DB if exist
     *
     * @param a item to delete
     */
    public void deleteItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if (employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
    }
}
