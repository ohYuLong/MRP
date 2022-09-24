package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.User;

public interface UserDao {

    int save(User user) throws Exception;

    User findUserByUsername(String username) throws Exception;



}
