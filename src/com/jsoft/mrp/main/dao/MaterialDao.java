package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.RawMaterial;

import java.util.List;

public interface MaterialDao {
    //查询所有
    List<RawMaterial> checkAll() throws Exception;


}
