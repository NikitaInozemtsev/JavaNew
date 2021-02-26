package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.model.Item;


public interface ItemRepository extends JpaRepository<Item, String> {
}
