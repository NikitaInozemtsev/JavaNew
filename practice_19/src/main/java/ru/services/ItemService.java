package ru.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.model.Item;
import ru.repositories.ItemRepository;

import java.util.List;

@Service
@Slf4j
public class ItemService {
    private  ItemRepository reps;

    public ItemService(ItemRepository reps) {
        this.reps = reps;
    }

    public List<Item> getItems() {
        log.info("Find all items");
        return reps.findAll();
    }

    public List<Item> orderByName() {
        log.info("Find all items order by name");
        return reps.findAll(Sort.by("name"));
    }

    public List<Item> orderByDate() {
        log.info("Find all items order by creationDate");
        return reps.findAll(Sort.by("creationDate"));
    }

    public List<Item> orderByPrice() {
        log.info("Find all items order by price");
        return reps.findAll(Sort.by("price"));
    }

    public void insertItem(Item a) {
        log.info("Save item {}", a);
        reps.save(a);
    }

    public void deleteItem(Item a) {
        log.info("Delete item {}", a);
        reps.delete(a);
    }
}
