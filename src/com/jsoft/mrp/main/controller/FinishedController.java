package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.Finished;
import com.jsoft.mrp.main.service.FinishedService;
import com.jsoft.mrp.main.service.impl.FinishedServiceImpl;
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

@WebServlet(name = "FinishedServlet", value = "*.dod")
public class FinishedController extends HttpServlet {
 private FinishedService finishedService = new FinishedServiceImpl();

    @Override
    public void init() throws ServletException {
        System.out.println("init....");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init.....");
    }

    public FinishedController() {
        System.out.println("constructor...");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(0,methodName.length() - 4);
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

//查询某些成品 模糊
    protected void checkOnes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pro = request.getParameter("product");
        List<Finished> finisheds = finishedService.listOnes(pro);

        PrintWriter out = response.getWriter();
        out.write(JSON.toJSONString(new ResultUtil("finisheds",finisheds)));
    }



//查询所有成品
    protected void checkFinishedAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Finished> finisheds = finishedService.listFinisheds();

        PrintWriter out = response.getWriter();

        out.write(JSON.toJSONString(new ResultUtil("finisheds",finisheds)));

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }
}
