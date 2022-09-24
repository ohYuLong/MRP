package com.jsoft.mrp.main.entity;

import java.sql.Date;

public class RawMaterial {
    private Integer id;
    private String material;
    private Integer num;
    private Integer price;
    private Date time;
    private String newtime;

    public RawMaterial() {
    }

    public RawMaterial(String material, Integer num, Integer price) {
        this.material = material;
        this.num = num;
        this.price = price;
    }

    public RawMaterial(Integer price,String material) {
        this.price = price;
        this.material = material;
    }

    public RawMaterial(String material) {
        this.material = material;
    }

    public RawMaterial(Integer id) {
        this.id = id;
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

}
