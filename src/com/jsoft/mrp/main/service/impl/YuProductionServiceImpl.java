package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.YuProductionDao;
import com.jsoft.mrp.main.dao.impl.YuProductionDaoImpl;
import com.jsoft.mrp.main.entity.YuProduction;
import com.jsoft.mrp.main.service.YuProductionService;

import java.util.List;

public class YuProductionServiceImpl implements YuProductionService {
    private YuProductionDao yuproductionDao = new YuProductionDaoImpl();

    @Override
    public List<YuProduction> initials() {
        List<YuProduction> productions = null;
        try {
            productions = yuproductionDao.initialPage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productions;
    }

    //模糊查询
    @Override
    public List<YuProduction> listOnes(String pre) {
        List<YuProduction> yuproductions;
        try {
            yuproductions = yuproductionDao.checkOnes(pre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return yuproductions;
    }

    //查询所有
    //service层
    @Override
    public List<YuProduction> listProduce(Integer page) {
        //每页显示多少条数据(自己规定的)
        Integer perpagenum = 15;//规定每页显示15条记录
        //根据公式 (当前页-1)*每页显示的记录数 可以得出 limit ? ,15 => ? 号的值
        Integer pagenum =(page -1) * 15;// 得出?号的值
        List<YuProduction> yuproductions = null;
        try {
            yuproductions = yuproductionDao.checkAll(pagenum,perpagenum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return yuproductions;
    }
}

