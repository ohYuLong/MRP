package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.SaleDao;
import com.jsoft.mrp.main.entity.Sale;
import com.jsoft.mrp.util.DAOImpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaleDaoImpl extends DAOImpl<Sale> implements SaleDao {
    //查询订单号
    @Override
    public Sale checkSid(Integer s_id) throws Exception {
        String sql = "SELECT* FROM sale WHERE s_id = ?";
        Sale sale = get(sql, s_id);

            sale.setNewtime(sale.getTime().toString());

        return sale;
    }


//改数量 单价




    @Override
    public Integer newwrite(Sale sale) throws Exception{
        System.out.println(sale);
        String sql = "update sale set num=?,sum=?,time=? where s_id=?";
        Date date = new Date();
        sale.setTime(date);

       // System.out.println(sale);

        Integer update = update(sql, sale.getNum(), sale.getSum(),sale.getTime(), sale.getS_id());

        return update;
    }
}
