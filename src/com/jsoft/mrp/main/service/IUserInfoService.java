package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.entity.UserInfo;
import com.jsoft.mrp.util.PageInfo;

import java.sql.SQLException;
import java.util.List;

public interface IUserInfoService {

    // 分页查询
    void queryForPage(PageInfo pageInfo) throws Exception;
    boolean checkUserIsExists(String username);
    // 添加用户
    boolean addUserInfo(UserInfo userInfo);
    int register(UserInfo userInfo);
    // 删除用户
    boolean deleteUserInfo(String username);
    // 修改用户
    boolean updateUserInfo(String userId, UserInfo userInfo);
    // 显示所有用户
    List<UserInfo> showALl();
    // 查找某个用户
    UserInfo findUserInfo(String userId);

}
