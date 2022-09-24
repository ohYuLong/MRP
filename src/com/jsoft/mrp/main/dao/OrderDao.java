package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.Order;

import java.util.List;

public interface OrderDao {
    int addOrder(Order order) throws Exception;
    List<Order> getOrder() throws Exception;
    Order getOrderById(Integer orderId) throws Exception;
    List<Order> getOrderByMaterial(String orderByMaterial) throws Exception;
    List<Order> vagueCheckByMaterial(String material) throws Exception;
//    List<Order> getOrderAllNum() throws Exception;
    List<Order> getOrderPage(int num) throws Exception;
    int getTotalOrderNum() throws Exception;
}
