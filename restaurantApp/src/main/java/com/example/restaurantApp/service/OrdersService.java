package com.example.restaurantApp.service;

import com.example.restaurantApp.DTO.OrdersDTO;
import com.example.restaurantApp.domain.OrderProduct;
import com.example.restaurantApp.domain.Orders;
import com.example.restaurantApp.mappers.OrdersMapper;
import com.example.restaurantApp.repository.OrderProductsRepostory;
import com.example.restaurantApp.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrdersService {
    private OrdersRepository ordersRepository;
    private OrdersMapper ordersMapper;
    private OrderProductsRepostory orderProductsRepostory;

    public OrdersService(OrdersRepository ordersRepository, OrdersMapper ordersMapper, OrderProductsRepostory orderProductsRepostory) {
        this.ordersRepository = ordersRepository;
        this.ordersMapper = ordersMapper;
        this.orderProductsRepostory = orderProductsRepostory;
    }

    public OrdersDTO createOrders(OrdersDTO ordersDTO) {
        Orders orders = ordersMapper.ordersDTOToOrders(ordersDTO);
        orders = ordersRepository.save(orders);
        for (OrderProduct orderProduct : orders.getOrderProductList()) {
            orderProductsRepostory.save(orderProduct);
        }
        return ordersMapper.ordersToOrdersDTO(orders);
    }

    public OrdersDTO updateOrderStatus(Long id, String status) {
        Orders orders = ordersRepository.getById(id);
        orders.setStatus(status);
        orders = ordersRepository.save(orders);
        return ordersMapper.ordersToOrdersDTO(orders);
    }


}
