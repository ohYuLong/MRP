package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.OrderDao;
import com.jsoft.mrp.main.entity.Order;
import com.jsoft.mrp.util.DAOImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OrderDaoImpl extends DAOImpl<Order> implements OrderDao {
    //int返回值为1就代表成功
    //    采购表：新增一条记录
    @Override
    public int addOrder(Order order) throws Exception {
        String sql = "insert into `order` (material,num,price,sum,buyerid,time) values (?,?,?,?,?,?)";
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        return update(sql,order.getMaterial(),order.getNum(),order.getPrice(),order.getSum(),order.getBuyerid(),t);
    }
    //    查询采购表所有
    @Override
    public List<Order> getOrder() throws Exception {
        String sql = "select * from `order` order by time desc";
        List<Order> forList = getForList(sql);
        return forList;
    }
    //    根据id查询
    @Override
    public Order getOrderById(Integer orderId) throws Exception {
        String sql = "select * from `order` where id = ?";
        return get(sql,orderId);
    }
    //    订单表：根据名字查询
    @Override
    public List<Order> getOrderByMaterial(String orderByMaterial) throws Exception {
        String sql = "select * from `order` where material = ? group by time desc";
        List<Order> forList = getForList(sql,orderByMaterial);
        Iterator<Order> iterator = forList.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        return forList;
    }
    //    根据名字模糊查询
    @Override
    public List<Order> vagueCheckByMaterial(String material) throws Exception {
        String sql = "select * from `order` where material like ? order by time desc";
        List<Order> forList = getForList(sql,material+"%");
        Iterator<Order> iterator = forList.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        return forList;
    }
        /*获取最新的一条的所有数量
    @Override
    public List<Order> getOrderAllNum() throws Exception {
        String sql = "select o.num from  `order`o where o.time in\n" +
                "                (select max(time) maxTime from `order` group by material HAVING max(time))\n" +
                "                GROUP BY o.material\n";
        List<Order> forList = getForList(sql);
        Iterator<Order> iterator = forList.iterator();
        while (iterator.hasNext()){
            Order next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        return forList;
    }*/
    //    分页查询，一页10条
    @Override
    public List<Order> getOrderPage(int num) throws Exception {
        String sql = "select * from `order` order by time desc limit ?,10";
        List<Order> orders = getForList(sql,num);
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        return orders;
    }
    //    获取总记录数
    @Override
    public int getTotalOrderNum() throws Exception {
        String sql = "select count(*) as num from `order`";
        return get(sql).getNum();
    }
}
class test{
    public static void main(String[] args) {
        OrderDaoImpl o=new OrderDaoImpl();
        try {
            System.out.println(o.vagueCheckByMaterial("b1"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

