package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.FlowInformation;
import com.jsoft.mrp.main.service.MoneyService;
import com.jsoft.mrp.main.service.impl.MoneyServiceImpl;
import com.jsoft.mrp.util.MessageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

@WebServlet("*.doMoney")
public class MoneyController extends HttpServlet {
    private MoneyService money=new MoneyServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  /admin/addVip.do
        String servletPath = req.getServletPath();
//      我现在可以拿到一个servlet的请求路径，在我这个类中，有一个addVip方法
        // 1.去掉第一个/     admin/addVip.do
        String methodName = servletPath.substring(1);
        // 2.截取成addVip
        methodName = methodName.substring(methodName.lastIndexOf("/") + 1,methodName.length() - 8);
        // 3.利用反射执行addVip方法
        try {
            // a.拿到当前类的要执行的方法对象
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // b.让方法执行
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch( InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    private void MainMoney(HttpServletRequest req, HttpServletResponse resp){
        int num1;
        int num2;
        int num3;
        num2=money.OrderMoney();
        num3=money.SaleMoney();
        num1=num3-num2;
        List<MessageUtil> mes=new LinkedList<>();
        /*String mes="'total':'num1','orderMoney':'num2','saleMoney':'num3'";*/
        mes.add(new MessageUtil(num1,"total"));
        mes.add(new MessageUtil(num2,"orderMoney"));
        mes.add(new MessageUtil(num3,"saleMoney"));
        try {
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(mes));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void queryAll(HttpServletRequest req, HttpServletResponse resp){
        int page = Integer.valueOf(req.getParameter("page"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            List<FlowInformation> information=money.QueryAll(page,start,end);
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(information));
            //System.out.println(11);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
private void queryOrder(HttpServletRequest req, HttpServletResponse resp){
        int page = Integer.valueOf(req.getParameter("page"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            List<FlowInformation> information=money.QueryOrder(page,start,end);
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(information));
            //System.out.println(11);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
private void querySale(HttpServletRequest req, HttpServletResponse resp){
        int page = Integer.valueOf(req.getParameter("page"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            List<FlowInformation> information=money.QuerySale(page,start,end);
            PrintWriter out = resp.getWriter();
            out.write(JSON.toJSONString(information));
            //System.out.println(11);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllNum(HttpServletRequest req, HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            PrintWriter out = resp.getWriter();
            int a=money.getAll(start,end);
           // System.out.println(a);
            out.write(JSON.toJSONString(a));
            //System.out.println(111);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }private void getOrderNum(HttpServletRequest req, HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            PrintWriter out = resp.getWriter();
            int a=money.getOrder(start,end);
           // System.out.println(a);
            out.write(JSON.toJSONString(a));
            //System.out.println(111);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }private void getSaleNum(HttpServletRequest req, HttpServletResponse resp){
        resp.setCharacterEncoding("UTF-8");
        String start = req.getParameter("start");
        String end = req.getParameter("end");
        try {
            PrintWriter out = resp.getWriter();
            int a=money.getSale(start,end);
            //System.out.println(a);
            out.write(JSON.toJSONString(a));
            //System.out.println(111);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

