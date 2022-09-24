package com.jsoft.mrp.main.dao;

import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.entity.UserInfo;
import com.jsoft.mrp.util.PageInfo;

import java.sql.SQLException;
import java.util.List;

public interface IUserInfoDao {


    // 查询页的总记录数
    void selectRecordCountForPage(PageInfo pageInfo) throws SQLException;

    // 查询当前页所有记录
    void selectRecordForPage(PageInfo pageInfo) throws Exception;

    UserInfo findUserByUsername(String username) throws Exception;

    int save(UserInfo userInfo) throws Exception;

    int insert(UserInfo userInfo) throws Exception;

    int delete(String userId) throws Exception;

    int update(String userid, UserInfo userInfo) throws Exception;

    List<UserInfo> getForList() throws Exception;

    UserInfo get(String userId) throws Exception;


}
