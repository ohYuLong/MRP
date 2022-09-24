package com.jsoft.mrp.main.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Order {
    private Integer id;
    private String material;
    private Integer num;
    private Integer price;
    private Integer sum;
    private Integer buyerid;
    private Date time;
    private String newtime;

    public Order() {
    }

    public Order(Integer id, String material, Integer num, Integer price, Integer sum, Integer buyerid, Date time) {
        this.id = id;
        this.material = material;
        this.num = num;
        this.price = price;
        this.sum = sum;
        this.buyerid = buyerid;
        this.time = time;
    }
    public Order(String material, Integer num, Integer price, Integer sum, Integer buyerid) {
        this.material = material;
        this.num = num;
        this.price = price;
        this.sum = sum;
        this.buyerid = buyerid;
    }
    public Order(String material, Integer num, Integer price) {
        this.material = material;
        this.num = num;
        this.price = price;
    }

    public Order(Integer id) {
        this.id = id;
    }

    public Order(String material) {
        this.material = material;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(Integer buyerid) {
        this.buyerid = buyerid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNewtime() {
        return newtime;
    }

    public void setNewtime(String newtime) {
        this.newtime = newtime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", sum=" + sum +
                ", buyer_id=" + buyerid +
                ", time=" + time +
                '}';
    }
}
