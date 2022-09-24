package com.jsoft.mrp.main.entity;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class UserInfo implements Serializable {


    private static final long serialVersionUID = -2352642267221918764L;
    private Integer id;
    private String username;
    private String password;
    private String department;
    private String name;
    private String time;
    private String salt;


    public UserInfo() {}

    public UserInfo(String username, String password,String department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public UserInfo(String username, String password, String department, String name) {
        this.username = username;
        this.password = password;
        this.department = department;
        this.name = name;
    }

    public UserInfo(Integer id, String username, String password, String department, String name, String time, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.department = department;
        this.name = name;
        this.time = time;
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
