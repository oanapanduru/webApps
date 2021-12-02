package com.example.restaurantApp.mappers;

import com.example.restaurantApp.DTO.OrderProductDTO;
import com.example.restaurantApp.domain.OrderProduct;
import com.example.restaurantApp.domain.OrderProductKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderProductMapper {

    @Autowired
    private ProductMapper productMapper;

    public OrderProductDTO OrderProductToOrderProductDTO(OrderProduct orderProduct) {
        OrderProductDTO orderProductDTO = new OrderProductDTO();
        orderProductDTO.setOrderId(orderProduct.getId().getOrderId());
        orderProductDTO.setProductDTO(productMapper.productToProductDTO(orderProduct.getProduct()));
        orderProductDTO.setQuantity(orderProduct.getQuantity());
        return orderProductDTO;
    }

    public OrderProduct OrderProductDTOToOrderProduct(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = new OrderProduct();
        OrderProductKey orderProductKey = new OrderProductKey();
        orderProductKey.setOrderId(orderProductDTO.getOrderId());
        orderProduct.setId(orderProductKey);
        orderProduct.setProduct(productMapper.productDTOToProduct(orderProductDTO.getProductDTO()));
        orderProduct.setQuantity(orderProductDTO.getQuantity());
        return orderProduct;
    }
}
