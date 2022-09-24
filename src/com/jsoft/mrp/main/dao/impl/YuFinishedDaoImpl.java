package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.YuFinishedDao;
import com.jsoft.mrp.main.entity.YuFinished;
import com.jsoft.mrp.util.DAOImpl;

import java.util.List;

public class YuFinishedDaoImpl extends DAOImpl<YuFinished> implements YuFinishedDao {

    //修改成品表的数量
    @Override
    public Integer updateNumByPname(String product, Integer number) throws Exception {
        String sql = "update finished set num = num - ? where product = ?";
        int i = update(sql, number, product);
        return i;
    }


    //通过成品名 查询对应的一条数据
    @Override
    public YuFinished checkyi(String prodcut) throws Exception {
        String sql = "select * from finished where product = ?";
        YuFinished finished = get(sql, prodcut);
        return finished;
    }

    //通过对应的成品名 查询对应的一条数据
    @Override
    public YuFinished checkOne(String product) throws Exception {
        String sql = "select * from finished where product = ?";
        YuFinished finished = get(sql, product);
        return finished;
    }

    //查成品product
    @Override
    public List<YuFinished> checkAll() throws Exception {
        String sql = "select * from finished";
        List<YuFinished> forList = getForList(sql);
        return forList;
    }
}
