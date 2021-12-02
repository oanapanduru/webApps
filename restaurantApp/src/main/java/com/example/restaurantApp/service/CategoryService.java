package com.example.restaurantApp.service;

import com.example.restaurantApp.DTO.CategoryDTO;
import com.example.restaurantApp.DTO.ProductDTO;
import com.example.restaurantApp.domain.Category;
import com.example.restaurantApp.domain.Product;
import com.example.restaurantApp.mappers.CategoryMapper;
import com.example.restaurantApp.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        for (Category category : categoryList) {
            categoryDTOList.add(categoryMapper.categoryToCategoryDTO(category));
        }
        return categoryDTOList;
    }

}
