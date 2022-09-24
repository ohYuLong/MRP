package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.YuSale;
import com.jsoft.mrp.main.service.YuSaleService;
import com.jsoft.mrp.main.service.impl.YuSaleServiceImpl;
import com.jsoft.mrp.util.ResultUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@WebServlet(name = "SaleManageServlet", value = "*.sale")
@MultipartConfig
public class YuSaleController extends HttpServlet {
    private YuSaleService saleService = new YuSaleServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length() - 5);

        try {
            // a.拿到当前类的要执行的方法对象
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            // b.让方法执行
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    //获取销售编号
     protected void findSaleId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro="";
        Integer i= (int)Math.floor(Math.random()*1000000);
         pro = pro+i;
         PrintWriter writer = response.getWriter();
         writer.write(pro);

     }

     //销售表里插入数据
    protected void addRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s = request.getReader().readLine();
      //  System.out.println(s);
        YuSale sale = JSON.parseObject(s, YuSale.class);
      //  System.out.println(sale);
        int i = saleService.insert(sale);
        PrintWriter out = response.getWriter();
        if(i>0){
            out.write(JSON.toJSONString(new ResultUtil("1","addSuccess!!!")));
        }else{
            out.write(JSON.toJSONString(new ResultUtil("0","addfail...")));
        }

    }



//查询销售表的所有记录
    protected void querylists(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        int p = Integer.parseInt(page);
        List<YuSale> sales = saleService.checkAll(p);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("sales",sales)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
