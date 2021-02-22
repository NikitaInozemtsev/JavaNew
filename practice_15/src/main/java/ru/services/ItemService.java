package ru.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Item;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private final SessionFactory sessionFactory;

    private Session session;

    public ItemService(SessionFactory sessionFactory) {
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

    public List<Item> getItems() {
        return session.createQuery("select i from Item i", Item.class).getResultList();
    }

    public void insertItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if(employee == null) {
            session.save(a);
        }
        session.getTransaction().commit();
    }

    public void deleteItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if(employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
    }
}
