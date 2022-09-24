package com.jsoft.mrp.main.service;

import com.jsoft.mrp.main.entity.User;

// 业务层
// 业务：软件的功能
// 登录，注册
// 我们在dao层写了一个方法save，保存
public interface UserService {

//    注册的方法
    int register(User user);

    boolean checkUserIsExists(String username);

    String login(User user);


}
