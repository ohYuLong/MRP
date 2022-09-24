package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.YuSale;


import java.util.List;

public interface YuSaleDao {

  //往销售表里插入数据
    Integer update(YuSale sale) throws Exception;



    //查询所有销售表历史记录
    List<YuSale> searchHistories(Integer p, Integer perPageNum)throws Exception;
}
