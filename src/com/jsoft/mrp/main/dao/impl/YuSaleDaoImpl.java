package com.jsoft.mrp.main.dao.impl;

import com.jsoft.mrp.main.dao.YuSaleDao;
import com.jsoft.mrp.main.entity.YuSale;
import com.jsoft.mrp.util.DAOImpl;

import java.util.List;

public class YuSaleDaoImpl extends DAOImpl<YuSale> implements YuSaleDao {
    //查询所有历史记录
    @Override
    public List<YuSale> searchHistories(Integer p ,Integer perPageNum) throws Exception {
        String sql = "select * from sale limit "+p+" ,"+perPageNum+"";
        List<YuSale> lists = getForList(sql);
        return lists;
    }

    //往销售表里插入数据
   @Override
    public Integer update(YuSale sale) throws Exception {
       String sql = "insert into sale (s_id,product,num,price,sum,saleperson_id,customer,time) values(?,?,?,?,?,?,?,?)";
       int i = update(sql, sale.getS_id(), sale.getProduct(), sale.getNum(),sale.getPrice(), sale.getSum(), sale.getSaleperson_id(), sale.getCustomer(), sale.getTime());
       return i;
    }


}

