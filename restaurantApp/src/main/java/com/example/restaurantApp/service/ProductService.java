package com.example.restaurantApp.service;

import com.example.restaurantApp.DTO.ProductDTO;
import com.example.restaurantApp.domain.Category;
import com.example.restaurantApp.domain.Product;
import com.example.restaurantApp.mappers.ProductMapper;
import com.example.restaurantApp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }


    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        ProductDTO productDTO = productMapper.productToProductDTO(product);
        return productDTO;
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            productDTOList.add(productMapper.productToProductDTO(product));
        }
        return productDTOList;
    }


    public List<ProductDTO> getProductsByCategory(Long id) {
        List<Product> productListByCategory = productRepository.findByCategoryId(id);
        List<ProductDTO> productDTOListByCategory = new ArrayList<>();
        for (Product product : productListByCategory) {
            productDTOListByCategory.add(productMapper.productToProductDTO(product));
        }
        return productDTOListByCategory;
    }

}
