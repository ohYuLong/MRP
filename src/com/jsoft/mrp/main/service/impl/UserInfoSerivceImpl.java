package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.IUserInfoDao;
import com.jsoft.mrp.main.dao.impl.UserInfoDaoImpl;
import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.entity.UserInfo;
import com.jsoft.mrp.main.service.IUserInfoService;
import com.jsoft.mrp.util.MD5Util;
import com.jsoft.mrp.util.PageInfo;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class UserInfoSerivceImpl implements IUserInfoService {
    IUserInfoDao dao = new UserInfoDaoImpl();
    // 分页查询
    @Override
    public void queryForPage(PageInfo pageInfo) throws Exception {
        dao.selectRecordCountForPage(pageInfo);
        // 设置页数
        pageInfo.setPageCount(pageInfo.getPageCount());
        dao.selectRecordForPage(pageInfo);
    }

    private IUserInfoDao userInfoDao= new UserInfoDaoImpl();

    @Override
    public boolean addUserInfo(UserInfo userInfo) {
        try {
            return userInfoDao.insert(userInfo) == 1;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public boolean deleteUserInfo(String id) {
        try {
            return userInfoDao.delete(id) == 1;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public boolean updateUserInfo(String userId, UserInfo userInfo) {
        try {
            return userInfoDao.update(userId,userInfo) == 1;
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public boolean checkUserIsExists(String username) {
        try {
            UserInfo userInfo = userInfoDao.findUserByUsername(username);
            /*
             *    如果根据用户名查到的vip是null，说明用户名可用，用户名在数据中是没有的
             *   如果返回值是true，则用户名可用
             * */
            return Objects.isNull(userInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int register(UserInfo userInfo) {
//        注册的业务执行的就是保存的操作
        try {
//            密码的加密处理
            // 生成盐
            String salt = MD5Util.getSalt();
            // 对密码进行加密
//            String newPassword = MD5Util.stringToMD5(vip.getPassword() + salt);
            // 加密过后还要重新赋值给vip
            userInfo.setPassword(MD5Util.stringToMD5(userInfo.getPassword() + salt));
            userInfo.setSalt(salt);
//            System.out.println(1111);
            return userInfoDao.save(userInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<UserInfo> showALl() {
        try {
            return userInfoDao.getForList();
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public UserInfo findUserInfo(String userId) {
        try {
            return userInfoDao.get(userId);
        } catch (Exception throwables) {
            throw new RuntimeException(throwables);
        }
    }


}
