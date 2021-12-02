package com.example.restaurantApp.controller;

import com.example.restaurantApp.DTO.CustomerDTO;
import com.example.restaurantApp.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<CustomerDTO> create(@RequestBody CustomerDTO customerDTO) {
        ResponseEntity<CustomerDTO> response;
        CustomerDTO customerResponse = customerService.createCustomer(customerDTO);
        if (customerResponse.getId() != null) {
            response = new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
        } else {
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
        ResponseEntity<CustomerDTO> response;
        CustomerDTO customerResponse = customerService.updateCustomer(customerDTO);
        response = new ResponseEntity<>(customerResponse, HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCustomer(@PathVariable(name = "id") Long id) {
        ResponseEntity<Void> response;
        customerService.deleteCustomer(id);
        response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name = "id") Long id) {
        ResponseEntity<CustomerDTO> response;
        response = new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
        return response;
    }
}
