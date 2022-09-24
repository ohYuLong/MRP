package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.YuFinished;

import java.util.List;

public interface YuFinishedDao {

    //修改成品表里的number字段
    Integer updateNumByPname(String product,Integer number) throws Exception;

    //查成品 product
    List<YuFinished> checkAll() throws Exception;
    //根据成品名 查询价格
    YuFinished checkOne(String product) throws Exception;
    //根据成品名 查询数量
    YuFinished checkyi(String prodcut) throws Exception;

}
