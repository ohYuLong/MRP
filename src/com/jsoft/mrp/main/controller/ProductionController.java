package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.main.service.ProductionService;
import com.jsoft.mrp.main.service.impl.ProductionServiceImpl;
import com.jsoft.mrp.util.PageDTO;
import com.jsoft.mrp.util.ResultUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ProductionController", value = "*.so")
public class ProductionController extends HttpServlet {
    private ProductionService productionService = new ProductionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length() - 3);

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
//模糊查询
    protected void checkPrefix(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pre = request.getParameter("product");
        List<Production> productions = productionService.listOnes(pre);
       // System.out.println(productions);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("productions",productions)));
    }

    //查询所有
    protected void checkProAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        Integer pa = Integer.parseInt(page);
        PageDTO<Production> pageDTO = productionService.listProduce(pa);

        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("productions", pageDTO )));
    }

    //删除对应的记录
    protected void delectOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer i = productionService.delectRecord(Integer.valueOf(id));
        PrintWriter out = response.getWriter();
        if(i >0){
            out.write(JSON.toJSONString(new ResultUtil("1","success")));
            return;
        }
      out.write(JSON.toJSONString(new ResultUtil("0","fail")));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
