package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.FlowInformation;

import java.util.List;

public interface MoneyService {
    List<FlowInformation> QueryAll(int num,String start,String end);
    int getAll(String start,String end);
    List<FlowInformation> QueryOrder(int num,String start,String end);
    int getOrder(String start,String end);
    List<FlowInformation> QuerySale(int num,String start,String end);
    int getSale(String start,String end);
    int OrderMoney();
    int SaleMoney();

}
