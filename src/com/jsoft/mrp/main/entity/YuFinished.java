package com.jsoft.mrp.main.entity;

import java.io.Serializable;
import java.util.Date;

public class YuFinished implements Serializable {
    private static final long serialVersionUID = 234567987656373L;
    private Integer id;
    private String product;
    private Integer num;
    private Integer price;
    private Date time;
    private String newtime;


    public YuFinished() {
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Finished{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", time=" + time +
                '}';
    }

}
