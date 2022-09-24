package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.Order;

import java.util.List;

public interface OrderService {
    int insertOrder(Order order);
    List<Order> getOrder();
    Order getOrderById(Integer orderId);
    List<Order> getOrderByMaterial(String orderByMaterial);
    List<Order> vagueCheckByMaterial(String material);
//    List<Order> getOrderAllNum();
    List<Order> getOrderPage(int num);
    int getTotalOrderNum();
}
