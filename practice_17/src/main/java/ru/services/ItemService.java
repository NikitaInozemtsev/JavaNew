package ru.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.Item;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.Connection;
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

    public List<Item> orderByName() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }

    public List<Item> orderByDate() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("creationDate")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }

    public List<Item> orderByPrice() {
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Item> itemCriteriaQuery = builder.createQuery(Item.class);
        Root<Item> root = itemCriteriaQuery.from(Item.class);
        itemCriteriaQuery.select(root).orderBy(builder.asc(root.get("price")));
        Query<Item> query = session.createQuery(itemCriteriaQuery);
        return query.getResultList();
    }

    public void insertItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if(employee == null) {
            session.save(a);
        }
        session.getTransaction().commit(); }

    public void deleteItem(Item a) {
        session.beginTransaction();
        Item employee = session.get(Item.class, a.getName());
        if(employee != null) {
            session.delete(employee);
        }
        session.getTransaction().commit();
    }
}
