package com.example.restaurantApp.controller;

import com.example.restaurantApp.DTO.CustomerDTO;
import com.example.restaurantApp.DTO.ProductDTO;
import com.example.restaurantApp.domain.Product;
import com.example.restaurantApp.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> getProductById(@PathVariable(name = "id") Long id) {
        ResponseEntity<ProductDTO> response;
        response = new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        return response;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        ResponseEntity<List<ProductDTO>> response;
        response = new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
        return response;
    }


    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductDTO>> getProductByCategory(@PathVariable(name = "category") Long id) {
        ResponseEntity<List<ProductDTO>> response;
        response = new ResponseEntity<>(productService.getProductsByCategory(id), HttpStatus.OK);
        return response;
    }

}
