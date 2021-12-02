package com.example.restaurantApp.controller;

import com.example.restaurantApp.DTO.OrdersDTO;
import com.example.restaurantApp.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/order")
public class OrdersController {

    private OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<OrdersDTO> create(@RequestBody OrdersDTO ordersDTO) {
        ResponseEntity<OrdersDTO> response;
        OrdersDTO orderResponse = ordersService.createOrders(ordersDTO);
        if (orderResponse.getId() != null) {
            response = new ResponseEntity<>(orderResponse, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @RequestMapping(value = "/{id}/{status}", method = RequestMethod.PUT)
    public ResponseEntity<OrdersDTO> updateCustomer(@PathVariable(name = "id") Long id, @PathVariable(name = "status") String status) {
        ResponseEntity<OrdersDTO> response;
        OrdersDTO ordersResponse = ordersService.updateOrderStatus(id, status);
        response = new ResponseEntity<>(ordersResponse, HttpStatus.OK);
        return response;
    }
}
