package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.YuSale;

import java.util.List;

public interface YuSaleService {

   //往销售表里插入数据
    Integer insert(YuSale sale);


    //查询所有销售表历史记录
    List<YuSale> checkAll(Integer page);

}
