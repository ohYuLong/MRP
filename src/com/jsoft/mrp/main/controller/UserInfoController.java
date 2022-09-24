package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jsoft.mrp.main.entity.UserInfo;
import com.jsoft.mrp.main.service.IUserInfoService;
import com.jsoft.mrp.main.service.impl.UserInfoSerivceImpl;
import com.jsoft.mrp.util.MessageUtil;
import com.jsoft.mrp.util.PageInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;


@WebServlet("*.do3")
@MultipartConfig
public class UserInfoController extends HttpServlet {


    private IUserInfoService userInfoSerivce = new UserInfoSerivceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置request,response编码
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String requestURI = req.getRequestURI();
        String methodName = requestURI.substring(requestURI.lastIndexOf("/")+1, requestURI.length() - 4);

        System.out.println("method: " + methodName);

        // 获取方法并调用方法(路由分配)
        try {
            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            // 如果没有该方法，退出
            return;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    // 分页显示用户基本信息，表连接
    private void showUserBaseInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        System.out.println("showUserBaseInfo execute");

        PageInfo pageInfo = new PageInfo(req);
        userInfoSerivce.queryForPage(pageInfo);

        System.out.println(pageInfo);
        List<UserInfo> userInfoBaseDetails = pageInfo.getList();
        System.out.println(userInfoBaseDetails);


        PrintWriter out = resp.getWriter();
        String s = JSONObject.toJSONString(pageInfo);
        out.write(s);


    }

    // 查询某个用户的基本信息，表连接
    private void findUserBaseInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UserInfo userInfo = userInfoSerivce.findUserInfo(req.getParameter("id"));
        System.out.println(userInfo);
        PrintWriter out = resp.getWriter();
        String s = JSONObject.toJSONString(userInfo);
        out.write(s);


    }

    private void addUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        System.out.println(department);
        UserInfo userInfo = new UserInfo(username,password,department,name);

        int i = userInfoSerivce.register(userInfo);
        System.out.println(i);
        if(i > 0) {
            out.write(JSON.toJSONString(new MessageUtil(1,"注册成功，请登录！")));
        } else {
            out.write(JSON.toJSONString(new MessageUtil(0,"注册失败，请重新填写！")));
        }

        out.flush();
        out.close();

    }


    // 删除用户信息
    private void delUserInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("delUserInfo execute");
        boolean isDel = userInfoSerivce.deleteUserInfo(req.getParameter("id"));
        System.out.println(isDel);
    }
    // 检查用户名是否存在
    private void checkUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        PrintWriter out = resp.getWriter();

        boolean b = userInfoSerivce.checkUserIsExists(username);

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

}
