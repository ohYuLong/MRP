/*
package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.main.entity.YuProduction;
import com.jsoft.mrp.main.service.YuProductionService;
import com.jsoft.mrp.main.service.impl.YuProductionServiceImpl;
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

@WebServlet(name = "YuProductionController", value = "*.so")
@MultipartConfig
public class YuProductionController extends HttpServlet {
    private YuProductionService yuproductionService = new YuProductionServiceImpl();
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
        List<YuProduction> productions = yuproductionService.listOnes(pre);
        Iterator<YuProduction> iterator = productions.iterator();
        while(iterator.hasNext()){
            YuProduction production = iterator.next();
          production.setNewtime(production.getTime().toString());
        }
       // System.out.println(productions);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("productions",productions)));
    }

    //查询所有
    protected void checkProAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        Integer pa = Integer.parseInt(page);
        List<YuProduction> yuproductions = yuproductionService.listProduce(pa);
        Iterator<YuProduction> iterator = yuproductions.iterator();
        while(iterator.hasNext()){
            YuProduction  yuproduction = iterator.next();
            yuproduction.setNewtime(yuproduction.getTime().toString());
        }
        System.out.println(yuproductions);
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("productions", yuproductions)));
    }
    protected void screen(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<YuProduction> initials = yuproductionService.initials();
        //System.out.println(initials);
        Iterator<YuProduction> iterator = initials.iterator();
        while(iterator.hasNext()){
            YuProduction yuproduction = iterator.next();
            yuproduction.setNewtime(yuproduction.getTime().toString());
        }
        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("initials",initials)));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
*/
