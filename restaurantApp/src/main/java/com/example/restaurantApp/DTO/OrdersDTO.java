package com.example.restaurantApp.DTO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrdersDTO {

    private Long id;

    private Timestamp registrationTime;

    private String status;

    private float price;

    CustomerDTO customerDTO;

    private List<OrderProductDTO> orderProductDTOList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Timestamp registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<OrderProductDTO> getOrderProductDTOList() {
        return orderProductDTOList;
    }

    public void setOrderProductDTOList(List<OrderProductDTO> orderProductDTOList) {
        this.orderProductDTOList = orderProductDTOList;
    }
}
