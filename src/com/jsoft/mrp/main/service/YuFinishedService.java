package com.jsoft.mrp.main.service;

import com.jsoft.mrp.main.entity.YuFinished;

import java.util.List;

public interface YuFinishedService {
    //查所有的product
    List<YuFinished> checkProducts();

    //根据成品名 查询价格
    String searchPrice(String product);

    //根据成品名， 查询数量
    Integer searchNumber(String product);

}
