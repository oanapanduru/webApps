package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
