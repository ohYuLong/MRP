package com.jsoft.mrp.main.dao.impl;



import com.jsoft.mrp.main.dao.moneyDao;
import com.jsoft.mrp.main.entity.FlowInformation;
import com.jsoft.mrp.util.DAOImpl;

import java.util.Iterator;
import java.util.List;

public class MoneyDaoImpl extends DAOImpl<FlowInformation> implements moneyDao {
    @Override
    public int OrderMoney() throws Exception {
        int sum=0;
        //所有订单的价格和数量
        String sql="select num,price from `order`";
        List<FlowInformation> f = getForList(sql);
        //所有销售的价格和数量

        Iterator<FlowInformation> iterator = f.iterator();
        while (iterator.hasNext()){
            FlowInformation next = iterator.next();
            sum=sum+next.getNum()*next.getPrice();
        }

        return sum;
    }

    @Override
    public int SaleMoney() throws Exception {
        int sum=0;
        String sql="select num,price from `sale`";
        List<FlowInformation> f = getForList(sql);
        Iterator<FlowInformation> iterator = f.iterator();
        while (iterator.hasNext()){
            FlowInformation next = iterator.next();
            sum=sum+next.getNum()*next.getPrice();
        }

        return sum;
    }


    @Override
    public int getAllNum(String start,String end) throws Exception {
        String sql="select count(*) as num from mm where time >= ? and time <= ?";
        return get(sql,start,end).getNum();
    }

    @Override
    public List<FlowInformation> queryAll(int num,String start,String end) throws Exception {
        String sql1="CREATE OR REPLACE VIEW mm \n" +
                "as\n" +
                "SELECT material as name,num,price,time\n" +
                "FROM `order`\n" +
                "union\n" +
                "SELECT product as name,num,price,time\n" +
                "FROM sale\n" +
                "ORDER BY time";
        update(sql1);
        String sql2="SELECT *\n" +
                "FROM mm\n" +
                "where time >= ?\n" +
                "and time <= ?\n" +
                "ORDER BY time DESC\n"+
                "LIMIT ?,10\n";
        List<FlowInformation> f=getForList(sql2,start,end,num);
        Iterator<FlowInformation> iterator = f.iterator();
        while (iterator.hasNext()){
            FlowInformation next = iterator.next();
            next.setNewTime(next.getTime().toString());
        }
        return f;
    }

    @Override
    public List<FlowInformation> queryOrder(int num,String start,String end) throws Exception {
        String sql="SELECT material as name,num,price,time\n" +
                "FROM `order`\n" +
                "where time >= ?\n" +
                "and time <= ?\n" +
                "ORDER BY time DESC\n" +
                "LIMIT ?,10";
        List<FlowInformation> f=getForList(sql,start,end,num);
        Iterator<FlowInformation> iterator = f.iterator();
        while (iterator.hasNext()){
            FlowInformation next = iterator.next();
            next.setNewTime(next.getTime().toString());
        }
        return f;
    }

    @Override
    public int getOrderNum(String start,String end) throws Exception {
        String sql="select count(*) as num from `order` where time >= ? and time <= ?";
        return get(sql,start,end).getNum();
    }

    @Override
    public List<FlowInformation> querySale(int num,String start,String end) throws Exception {
        String sql="select product as name,num,price,time\n" +
                "from sale\n" +
                "where time >= ?\n" +
                "and time <= ?\n" +
                "ORDER BY time DESC\n" +
                "LIMIT ?,10";
        List<FlowInformation> f=getForList(sql,start,end,num);
        Iterator<FlowInformation> iterator = f.iterator();
        while (iterator.hasNext()){
            FlowInformation next = iterator.next();
            next.setNewTime(next.getTime().toString());
        }
        return f;
    }

    @Override
    public int getSaleNum(String start,String end) throws Exception {
        String sql="select count(*) as num from sale where time >= ? and time <= ?";
        return get(sql,start,end).getNum();
    }
}



