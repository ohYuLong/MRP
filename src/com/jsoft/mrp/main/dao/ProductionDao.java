package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.util.PageDTO;

import java.util.List;

public interface ProductionDao {
    //查询所有
    List<Production> checkAll(Integer startPage, Integer perPageNum) throws Exception;

    //查询生产表里的总记录数
    Long checkRecords()throws Exception;

    //模糊查询
    List<Production> checkOnes(String pre) throws Exception;

    //删除对应的记录
    Integer delectOne(Integer id) throws Exception;


}
