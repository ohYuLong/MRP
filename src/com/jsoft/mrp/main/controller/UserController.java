package com.jsoft.mrp.main.controller;


import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.User;
import com.jsoft.mrp.main.service.UserService;
import com.jsoft.mrp.main.service.impl.UserServiceImpl;
import com.jsoft.mrp.util.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/*
 *   有一个约定
 *   前台提交的请求，必须提交到   /admin/xxx.do
 *
 *   我们当前的servlet只接受*.do结尾的请求
 *
 *   当我们写*.do的时候，前面不能写/
 *
 *   配置servlet映射的时候，*和/不能同时出现，/*除外
 *
 * */
@WebServlet("*.do")
@MultipartConfig // 用来标记当前的servlet要接收多部分的数据格式，当前的servlet可以接收文件
public class UserController extends HttpServlet {

    //    Controller调用service
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  /admin/addVip.do
        String servletPath = req.getServletPath();
//      我现在可以拿到一个servlet的请求路径，在我这个类中，有一个addVip方法
        // 1.去掉第一个/     admin/addVip.do
        String methodName = servletPath.substring(1);
        // 2.截取成addVip
        methodName = methodName.substring(methodName.lastIndexOf("/") + 1,methodName.length() - 3);
        // 3.利用反射执行addVip方法
        try {
            // a.拿到当前类的要执行的方法对象
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // b.让方法执行
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        User user = new User(username,password,department,name);
        int i = userService.register(user);
        System.out.println(i);
//        System.out.println(11111);
        if(i > 0) {
            out.write(JSON.toJSONString(new MessageUtil(1,"注册成功，请登录！")));
        } else {
            out.write(JSON.toJSONString(new MessageUtil(0,"注册失败，请重新填写！")));
        }

        out.flush();
        out.close();

    }

    private void checkUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();

        boolean b = userService.checkUserIsExists(username);

        /*
         *   ajax发请求，后台一定不能跳页面。想跳页面，在前台的JS中去跳
         * */
//       后台返回的数据是统一的格式
        if(b) {
            out.write(JSON.toJSONString(new MessageUtil(1,"用户名可用")));
        }else {
            out.write(JSON.toJSONString(new MessageUtil(0,"用户名已存在")));
        }

        out.flush();
        out.close();
    }


    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
//        接收验证码
        String myCode = req.getParameter("code");
//        我们前台传过来的code和谁去比？？？？
        String sessionCode = (String) req.getSession().getAttribute("code");
        if(Objects.equals(myCode,sessionCode)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String department = req.getParameter("department");
            String b = userService.login(new User(username, password,department));
            if(b != "") {
//            登录成功！！！
//            out.write("登录成功！");
//            如果登录成功，就把用户名放进session会话
                req.getSession().setAttribute("user",username);
                if(Objects.equals(b,"boss")){
                    out.write(JSON.toJSONString(new MessageUtil(2,"管理员登录成功！")));
                }
                if(Objects.equals(b,"采购部")){
                    out.write(JSON.toJSONString(new MessageUtil(3,"采购员登录成功！")));
                    System.out.println(11111);
                }
                if(Objects.equals(b,"销售部")){
                    out.write(JSON.toJSONString(new MessageUtil(4,"销售员登录成功！")));
                }
                if(Objects.equals(b,"仓库部")){
                    out.write(JSON.toJSONString(new MessageUtil(5,"仓库员登录成功！")));
                }
                if(Objects.equals(b,"生产部")){
                    out.write(JSON.toJSONString(new MessageUtil(6,"生产员登录成功！")));
                }
                if(Objects.equals(b,"财务部")){
                    out.write(JSON.toJSONString(new MessageUtil(7,"财务员登录成功！")));
                }
            }
            else {
//            登录失败，账号或密码错误！！！
                out.write(JSON.toJSONString(new MessageUtil(1,"账号或密码错误！")));
            }
        }else {
            out.write(JSON.toJSONString(new MessageUtil(0,"验证码错误！")));
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
