package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.impl.MoneyDaoImpl;
import com.jsoft.mrp.main.dao.moneyDao;
import com.jsoft.mrp.main.entity.FlowInformation;
import com.jsoft.mrp.main.service.MoneyService;

import java.util.List;

public class MoneyServiceImpl implements MoneyService {
    private moneyDao m=new MoneyDaoImpl();

    @Override
    public int OrderMoney() {
        try {
            return m.OrderMoney();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int SaleMoney() {
        try {
            return m.SaleMoney();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getAll(String start,String end) {
        try {
            return m.getAllNum(start, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<FlowInformation> QueryAll(int num,String start,String end) {
        try {
            return m.queryAll(num,start,end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FlowInformation> QueryOrder(int num,String start,String end) {

        try {
            return  m.queryOrder(num,start,end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getOrder(String start,String end) {
        try {
            return m.getOrderNum(start, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<FlowInformation> QuerySale(int num,String start,String end) {
        try {
            return m.querySale(num,start,end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getSale(String start,String end) {
        try {
            return m.getSaleNum(start, end);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
