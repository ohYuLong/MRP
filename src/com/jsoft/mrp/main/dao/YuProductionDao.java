package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.YuProduction;

import java.util.List;

public interface YuProductionDao {
    List<YuProduction> checkAll(Integer pagenum, Integer perpagenum) throws Exception;
    List<YuProduction> checkOnes(String pre) throws Exception;

    //初始的页面显示
    List<YuProduction> initialPage()throws Exception;
}
