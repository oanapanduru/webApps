package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
