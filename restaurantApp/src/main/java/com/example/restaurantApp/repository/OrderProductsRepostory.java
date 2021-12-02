package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.OrderProduct;
import com.example.restaurantApp.domain.OrderProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductsRepostory extends JpaRepository<OrderProduct, OrderProductKey> {
}
