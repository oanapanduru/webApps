package com.example.restaurantApp.mappers;

import com.example.restaurantApp.DTO.OrderProductDTO;
import com.example.restaurantApp.DTO.OrdersDTO;
import com.example.restaurantApp.domain.OrderProduct;
import com.example.restaurantApp.domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrdersMapper {

    @Autowired
    private OrderProductMapper orderProductMapper;
    @Autowired
    private CustomerMapper customerMapper;

    public OrdersDTO ordersToOrdersDTO(Orders orders) {
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setId(orders.getId());
        ordersDTO.setRegistrationTime(orders.getRegistrationTime());
        ordersDTO.setStatus(orders.getStatus());
        ordersDTO.setCustomerDTO(customerMapper.customerToCustomerDTO(orders.getCustomer()));
        ordersDTO.setPrice(orders.getPrice());
        if (orders.getOrderProductList() != null) {
            List<OrderProductDTO> orderProductDTOList = new ArrayList<>();
            for (OrderProduct orderProduct : orders.getOrderProductList()) {
                orderProductDTOList.add(orderProductMapper.OrderProductToOrderProductDTO(orderProduct));
            }
            ordersDTO.setOrderProductDTOList(orderProductDTOList);
        }

        return ordersDTO;
    }


    public Orders ordersDTOToOrders(OrdersDTO ordersDTO) {
        Orders orders = new Orders();
        orders.setId(ordersDTO.getId());
        orders.setRegistrationTime(ordersDTO.getRegistrationTime());
        orders.setStatus(ordersDTO.getStatus());
        orders.setCustomer(customerMapper.customerDTOtoCustomer(ordersDTO.getCustomerDTO()));
        orders.setPrice(ordersDTO.getPrice());
        if (ordersDTO.getOrderProductDTOList() != null) {
            List<OrderProduct> orderProductList = new ArrayList<>();
            for (OrderProductDTO orderProductDTO : ordersDTO.getOrderProductDTOList()) {
                OrderProduct orderProduct = orderProductMapper.OrderProductDTOToOrderProduct(orderProductDTO);
                orderProduct.setOrders(orders);
                orderProductList.add(orderProduct);
            }
            orders.setOrderProductList(orderProductList);
        }
        return orders;
    }
}
