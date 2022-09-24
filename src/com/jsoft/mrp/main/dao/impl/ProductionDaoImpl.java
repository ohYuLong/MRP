package com.jsoft.mrp.main.dao.impl;

import com.jsoft.mrp.main.dao.ProductionDao;
import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.util.DAOImpl;
import com.jsoft.mrp.util.PageDTO;

import java.util.List;

public class ProductionDaoImpl extends DAOImpl<Production> implements ProductionDao {
    @Override
    public Integer delectOne(Integer id) throws Exception {
        String sql = "delete from production where id = ?";
        int i = update(sql, id);
        return i;
    }

    //查询生产表里的总记录数
    @Override
    public Long checkRecords() throws Exception {
        String sql = "select count(*) from production";
        Long sum =getForValue(sql) ;
        return sum;
    }

    //模糊查询
    @Override
    public List<Production> checkOnes(String pre) throws Exception {
        String sql ="select * from production where product like \""+ pre +"%\"";
        List<Production> produce = getForList(sql);
        return produce;
    }


//查询所有 分页
    @Override
    public List<Production> checkAll(Integer startPage,Integer perPageNum) throws Exception {
        String sql = "select * from production limit ?,? ";
        List<Production> productions = getForList(sql, startPage, perPageNum);
        return productions;
    }
}

//class test{
//    public static void main(String[] args) throws Exception {
//        ProductionDaoImpl  p = new ProductionDaoImpl();
//        System.out.println(p.initialPage());
//
//    }
//}
