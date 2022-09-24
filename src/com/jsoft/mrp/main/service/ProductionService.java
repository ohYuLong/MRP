package com.jsoft.mrp.main.service;

import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.util.PageDTO;

import java.util.List;

public interface ProductionService {

    //查询所有   要分页导航 传入的参数为当前页
    PageDTO<Production> listProduce(Integer currentPage);

    //模糊查询
    List<Production> listOnes(String pre);

    //删除对应记录
    Integer delectRecord(Integer id);
}
