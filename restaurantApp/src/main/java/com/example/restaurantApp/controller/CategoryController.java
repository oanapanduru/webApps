package com.example.restaurantApp.controller;

import com.example.restaurantApp.DTO.CategoryDTO;
import com.example.restaurantApp.DTO.ProductDTO;
import com.example.restaurantApp.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/api/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        ResponseEntity<List<CategoryDTO>> response;
        response = new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
        return response;
    }

}
