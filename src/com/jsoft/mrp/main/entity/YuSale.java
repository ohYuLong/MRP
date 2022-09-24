package com.jsoft.mrp.main.entity;

import java.io.Serializable;
import java.util.Date;

public class YuSale implements Serializable {
    private static final long serialVersionUID = 3456987090909L;
    private Integer id;
    private Integer s_id;
    private String product;
    private Integer num;
    private Integer price;
    private Integer sum;
    private Integer saleperson_id;
    private String customer;
    private Date time;

    public YuSale() {
    }

    public YuSale(Integer s_id, String product, Integer num, Integer price, Integer sum, Integer saleperson_id, String customer, Date time) {
        this.s_id = s_id;
        this.product = product;
        this.num = num;
        this.price = price;
        this.sum = sum;
        this.saleperson_id = saleperson_id;
        this.customer = customer;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getS_id() {
        return s_id;
    }

    public void setS_id(Integer s_id) {
        this.s_id = s_id;
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

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public Integer getSaleperson_id() {
        return saleperson_id;
    }

    public void setSaleperson_id(Integer saleperson_id) {
        this.saleperson_id = saleperson_id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", s_id=" + s_id +
                ", product='" + product + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", sum=" + sum +
                ", saleperson_id=" + saleperson_id +
                ", customer='" + customer + '\'' +
                ", time=" + time +
                '}';
    }
}
