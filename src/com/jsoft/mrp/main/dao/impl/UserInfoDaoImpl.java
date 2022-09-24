package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.IUserInfoDao;
import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.entity.UserInfo;
import com.jsoft.mrp.util.DAOImpl;
import com.jsoft.mrp.util.PageInfo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserInfoDaoImpl extends DAOImpl<UserInfo> implements IUserInfoDao {
//    UserInfoDaoImpl dao = new UserInfoDaoImpl();
//    // 分页查询
//    @Override
//    public void queryForPage(PageInfo pageInfo) throws Exception {
//        dao.selectRecordCountForPage(pageInfo);
//        // 设置页数
//        pageInfo.setPageCount(pageInfo.getPageCount());
//        dao.selectRecordForPage(pageInfo);
//    }

    @Override
    public int save(UserInfo userInfo) throws Exception {
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        String sql = "insert into user(username,password,department,name,salt,time) values(?,?,?,?,?,?)";
        return update(sql,userInfo.getUsername(),userInfo.getPassword(),userInfo.getDepartment(),userInfo.getName(),userInfo.getSalt(),t);
    }

    @Override
    public void selectRecordCountForPage(PageInfo pageInfo) throws SQLException {
        String sql = "SELECT count(*) FROM user";
        System.out.println("getForValue: " + getForValue(sql));
        pageInfo.setRecordCount((Long) getForValue(sql));
    }

    @Override
    public void selectRecordForPage(PageInfo pageInfo) throws Exception {
        String sql = "SELECT  * FROM `user` ORDER BY time desc LIMIT ?,?";
        List<UserInfo> forList = getForList(sql, (pageInfo.getCurrentPage() - 1) * pageInfo.getRecordSize(), pageInfo.getRecordSize());
        pageInfo.setList(forList);
    }

    @Override
    public int insert(UserInfo userInfo) throws Exception {
        String sql = "INSERT INTO user(username,password,name,department,time) VALUES(?,?,?,?,?)";
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        return update(sql,userInfo.getUsername(),userInfo.getPassword(),userInfo.getName(),userInfo.getDepartment()
                ,t);
    }

    @Override
    public int delete(String id) throws Exception {
        String sql = "DELETE FROM user WHERE id = ?";
        return update(sql,id);
    }

    @Override
    public UserInfo findUserByUsername(String id) throws Exception {
        String sql = "select * from user where id = ?";
        return get(sql,id);
    }

    @Override
    public int update(String userid, UserInfo userInfo) throws Exception {
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        String sql = "UPDATE user SET username=?,password=?,name=?,department=?,?,WHERE id=?";
        return update(sql,userInfo.getUsername(),userInfo.getPassword(),userInfo.getDepartment(),t,userid);
    }

    @Override
    public List<UserInfo> getForList() throws Exception {
        String sql = "SELECT * FROM user ORDER BY `time` DESC";
        return getForList(sql);
    }

    @Override
    public UserInfo get(String userId) throws Exception {
        String sql = "SELECT * FROM user where id=?";
        return get(sql,userId);
    }
}
