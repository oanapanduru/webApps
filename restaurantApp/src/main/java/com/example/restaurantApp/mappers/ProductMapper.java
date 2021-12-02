package com.example.restaurantApp.mappers;

import com.example.restaurantApp.DTO.OrdersDTO;
import com.example.restaurantApp.DTO.ProductDTO;
import com.example.restaurantApp.domain.Orders;
import com.example.restaurantApp.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    @Autowired
    CategoryMapper categoryMapper;

    public ProductDTO productToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setNameOfFood(product.getNameOfFood());
        productDTO.setPrice(product.getPrice());
        if(product.getCategory() != null) {
            productDTO.setCategoryDTO(categoryMapper.categoryToCategoryDTO(product.getCategory()));
        }
        return productDTO;
    }

    public Product productDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setNameOfFood(productDTO.getNameOfFood());
        product.setPrice(productDTO.getPrice());
        if(productDTO.getCategoryDTO() != null) {
            product.setCategory(categoryMapper.categoryDTOToCategory(productDTO.getCategoryDTO()));
        }
        return product;
    }
}
