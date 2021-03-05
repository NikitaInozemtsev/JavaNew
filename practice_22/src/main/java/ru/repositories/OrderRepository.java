package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.model.Order;


public interface OrderRepository extends JpaRepository<Order, String> {
}
