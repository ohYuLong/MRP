package com.jsoft.mrp.main.entity;

import java.util.Date;

public class FlowInformation {
    private String name;
    private int num;
    private int price;
    private Date time;
    private String newTime;
    //private int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNewTime() {
        return newTime;
    }

    public void setNewTime(String newTime) {
        this.newTime = newTime;
    }


    @Override
    public String toString() {
        return "FlowInformation{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", time=" + time +
                ", newTime='" + newTime +
                '}';
    }
}
