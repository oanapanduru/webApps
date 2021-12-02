package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
