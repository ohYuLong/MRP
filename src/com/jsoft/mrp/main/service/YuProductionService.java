package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.YuProduction;

import java.util.List;

public interface YuProductionService {

    //查询所有   要分页导航
    List<YuProduction> listProduce(Integer page);

    //模糊查询
    List<YuProduction> listOnes(String pre);

    //初始页面显示的数据
    List<YuProduction> initials();
}
