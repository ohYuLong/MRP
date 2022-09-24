package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.FlowInformation;

import java.util.List;

public interface moneyDao {
    int OrderMoney() throws Exception;
    int SaleMoney() throws Exception;
    List<FlowInformation> queryAll(int num,String start,String end) throws Exception;
    int getAllNum(String start,String end) throws Exception;
    List<FlowInformation> queryOrder(int num,String start,String end) throws Exception;
    int getOrderNum(String start,String end) throws Exception;
    List<FlowInformation> querySale(int num,String start,String end) throws Exception;
    int getSaleNum(String start,String end) throws Exception;

}
