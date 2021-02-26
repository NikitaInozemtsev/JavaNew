package ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.model.Item;
import ru.repositories.ItemRepository;

import java.util.List;

@Service
public class ItemService {


    private  ItemRepository reps;

    public ItemService(ItemRepository reps) {
        this.reps = reps;
    }

    public List<Item> getItems() {
        return reps.findAll();
    }

    public List<Item> orderByName() {
        return reps.findAll(Sort.by("name"));
    }

    public List<Item> orderByDate() {
        return reps.findAll(Sort.by("creationDate"));
    }

    public List<Item> orderByPrice() {
        return reps.findAll(Sort.by("price"));
    }

    public void insertItem(Item a) {
        reps.save(a);
    }

    public void deleteItem(Item a) {
        reps.delete(a);
    }
}
