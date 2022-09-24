package com.jsoft.mrp.main.entity;

import java.io.Serializable;

/*
*   和表对应的实体类，entity
*   要求：
*       1.类名和表名相同
*       2.类中的属性名和表中的字段名相同
*       3.类中只能有对应的set，get方法和需要用到的构造器，如果有需要，可以写toString。
*       4.序列化。实现序列化接口
* */
public class User implements Serializable {


    private static final long serialVersionUID = -2352642267221918764L;
    private Integer id;
    private String username;
    private String password;
    private String department;
    private String name;
    private String profile;
    private String salt;


    public User() {}

    public User(String username, String password,String department) {
        this.username = username;
        this.password = password;
        this.department = department;
    }

    public User(String username, String password, String department, String name) {
        this.username = username;
        this.password = password;
        this.department = department;
        this.name = name;
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

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department='" + department + '\'' +
                ", name='" + name + '\'' +
                ", profile='" + profile + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
