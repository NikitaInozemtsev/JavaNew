package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.model.Item;


public interface ItemRepository extends JpaRepository<Item, String> {
}
