package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.YuProductionDao;
import com.jsoft.mrp.main.entity.YuProduction;
import com.jsoft.mrp.util.DAOImpl;

import java.util.List;

public class YuProductionDaoImpl extends DAOImpl<YuProduction> implements YuProductionDao {
    //模糊查询
    @Override
    public List<YuProduction> checkOnes(String pre) throws Exception {
        String sql ="select * from production where product like \""+ pre +"%\"";
        List<YuProduction> produce = getForList(sql);
        return produce;
    }
//查询所有 分页
    @Override
    public List<YuProduction> checkAll(Integer pagenum,Integer perpagenum) throws Exception {
        String sql = "select * from production limit ?,?";
        List<YuProduction> productions = getForList(sql,pagenum,perpagenum);
        return productions;
    }


    //初始化页面显示的数据
    @Override
    public List<YuProduction> initialPage() throws Exception {
        String sql = "select * from production limit 0,15";
        List<YuProduction> forList = getForList(sql);
        return forList;
    }
}

//class test{
//    public static void main(String[] args) throws Exception {
//        ProductionDaoImpl  p = new ProductionDaoImpl();
//        System.out.println(p.initialPage());
//
//    }
//}
