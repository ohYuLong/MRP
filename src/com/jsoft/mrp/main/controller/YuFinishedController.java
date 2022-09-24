package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.YuFinished;
import com.jsoft.mrp.main.service.YuFinishedService;
import com.jsoft.mrp.main.service.impl.YuFinishedServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet(name = "YuFinishedServlet", value = "*.finish")
@MultipartConfig
public class YuFinishedController extends HttpServlet {
    private YuFinishedService finishedService = new YuFinishedServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length() - 7);

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

    //查询成品 product
    protected void checkProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<YuFinished> finisheds = finishedService.checkProducts();
        PrintWriter writer = response.getWriter();
        writer.write(JSON.toJSONString(finisheds));
    }

    //获取对应成品的价格
    protected void checkPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        String price = finishedService.searchPrice(product);
        PrintWriter out = response.getWriter();
        out.write(price);
    }


    //获取对应成品的数量
    protected void checkNumber(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product = request.getParameter("product");
        Integer num = finishedService.searchNumber(product);
        PrintWriter out = response.getWriter();
        out.print(num);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
    }
}
