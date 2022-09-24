package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.YuFinishedDao;
import com.jsoft.mrp.main.dao.impl.YuFinishedDaoImpl;
import com.jsoft.mrp.main.entity.YuFinished;
import com.jsoft.mrp.main.service.YuFinishedService;

import java.util.List;

public class YuFinishedServiceImpl implements YuFinishedService {
    private YuFinishedDao finishedDao = new YuFinishedDaoImpl();
    //根据成拼命 查对应的数量
    @Override
    public Integer searchNumber(String product) {
        Integer num  = null;
        try {
            YuFinished finished = finishedDao.checkyi(product);
            num = finished.getNum();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return num;
    }

    //根据成品名 查对应的价格
    @Override
    public String searchPrice(String product) {
        String price = null;
        try {
            // System.out.println(product);
            YuFinished finished = finishedDao.checkOne(product);

            return price = Integer.toString(finished.getPrice());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    //查所有的product成品
    @Override
    public List<YuFinished> checkProducts() {
        List<YuFinished> finisheds = null;
        try {
            finisheds = finishedDao.checkAll();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return finisheds;
    }
}
