package com.jsoft.mrp.main.entity;

import java.io.Serializable;
import java.util.Date;

public class YuProduction implements Serializable {
    private static final long serialVersionUID = 335626976415477L;
    private Integer id;
    private String material;
    private String product;
    private Integer m_num;
    private Integer p_num;
    private Date time;
    private String newtime;

    public YuProduction() {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getM_num() {
        return m_num;
    }

    public void setM_num(Integer m_num) {
        this.m_num = m_num;
    }

    public Integer getP_num() {
        return p_num;
    }

    public void setP_num(Integer p_num) {
        this.p_num = p_num;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Production{" +
                "id=" + id +
                ", material='" + material + '\'' +
                ", product='" + product + '\'' +
                ", m_num=" + m_num +
                ", p_num=" + p_num +
                ", time=" + time +
                '}';
    }
}
