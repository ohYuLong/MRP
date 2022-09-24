package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.OrderDao;
import com.jsoft.mrp.main.dao.impl.OrderDaoImpl;
import com.jsoft.mrp.main.dao.impl.RawMaterialDaoImpl;
import com.jsoft.mrp.main.entity.Order;
import com.jsoft.mrp.main.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao dao = new OrderDaoImpl();
    @Override
    public int insertOrder(Order order) {
        try {
            RawMaterialDaoImpl rawMaterialDao = new RawMaterialDaoImpl();
            rawMaterialDao.updateRawMaterialNum(order.getMaterial(),order.getNum());
            return dao.addOrder(order);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Order> getOrder() {
        List<Order> orders = null;
        try {
            return orders = dao.getOrder();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Order getOrderById(Integer orderId) {
        try {
            return dao.getOrderById(orderId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Order> getOrderByMaterial(String orderByMaterial) {
        List<Order> orders = null;
        try {
            return orders = dao.getOrderByMaterial(orderByMaterial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<Order> vagueCheckByMaterial(String material) {
        List<Order> orders = null;
        try {
            return orders = dao.vagueCheckByMaterial(material);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /*@Override
    public List<Order> getOrderAllNum() {
        List<Order> orders = null;
        try {
            return orders = dao.getOrderAllNum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
    @Override
    public List<Order> getOrderPage(int num) {
        try {
            return dao.getOrderPage(num);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getTotalOrderNum() {
        try {
            return dao.getTotalOrderNum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
