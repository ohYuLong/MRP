package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.UserDao;
import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.util.DAOImpl;

import java.sql.Timestamp;
import java.util.Date;

public class UserDaoImpl extends DAOImpl<User> implements UserDao {


    @Override
    public int save(User user) throws Exception {
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        String sql = "insert into user(username,password,department,name,salt,time) values(?,?,?,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getDepartment(),user.getName(),user.getSalt(),t);
    }

    @Override
    public User findUserByUsername(String username) throws Exception {
        String sql = "select * from user where username = ?";
        return get(sql,username);
    }
}
