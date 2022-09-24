package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.UserDao;
import com.jsoft.mrp.main.dao.impl.UserDaoImpl;
import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.service.UserService;
import com.jsoft.mrp.util.MD5Util;

import java.util.Objects;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public int register(User user) {
//        注册的业务执行的就是保存的操作
        try {
//            密码的加密处理
            // 生成盐
            String salt = MD5Util.getSalt();
            // 对密码进行加密
//            String newPassword = MD5Util.stringToMD5(vip.getPassword() + salt);
            // 加密过后还要重新赋值给vip
            user.setPassword(MD5Util.stringToMD5(user.getPassword() + salt));
            user.setSalt(salt);
//            System.out.println(1111);
            return dao.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean checkUserIsExists(String username) {
        try {
            User user = dao.findUserByUsername(username);
            /*
            *    如果根据用户名查到的vip是null，说明用户名可用，用户名在数据中是没有的
            *   如果返回值是true，则用户名可用
            * */
            return Objects.isNull(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String login(User user) {
        try {
            User userByUsername = dao.findUserByUsername(user.getUsername());
//            System.out.println(userByUsername);
            if(Objects.isNull(userByUsername)) {
//                System.out.println("111111111111");
                return null;
            }
            String salt = userByUsername.getSalt();
            String password = MD5Util.stringToMD5(user.getPassword() + salt);
            if(!password.equals(userByUsername.getPassword())){
//                System.out.println("2222222222222");
                return null;
            }
            String department = userByUsername.getDepartment();;
            return department;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
