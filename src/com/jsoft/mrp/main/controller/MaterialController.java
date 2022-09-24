package com.jsoft.mrp.main.controller;


import com.alibaba.fastjson.JSON;

import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.main.service.MaterialService;
import com.jsoft.mrp.main.service.impl.MaterialServiceImpl;
import com.jsoft.mrp.util.ResultUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "MaterialServlet", value = "/checkAll.do")
public class MaterialController extends HttpServlet {
    private MaterialService materialService = new MaterialServiceImpl();
    //查询所有
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<RawMaterial> materials = materialService.listMaterials();

        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(new ResultUtil("materials",materials)));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
