package com.jsoft.mrp.main.controller;

import com.alibaba.fastjson.JSON;
import com.jsoft.mrp.main.entity.Order;
import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.main.service.OrderService;
import com.jsoft.mrp.main.service.RawMaterialService;
import com.jsoft.mrp.main.service.impl.OrderServiceImpl;
import com.jsoft.mrp.main.service.impl.RawMaterialServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

@WebServlet("*.doZhang")
public class OmsController extends HttpServlet {
    private OrderService orderService = new OrderServiceImpl();
    private RawMaterialService rawMaterialService = new RawMaterialServiceImpl();

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String methodName = servletPath.substring(1);
        methodName = methodName.substring(methodName.lastIndexOf("/") + 1, methodName.length() - 8);
        try {
            Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {

            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    //    ????????????????????????
    protected void insertOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String material = req.getParameter("material");
        int num = Integer.valueOf(req.getParameter("num"));
        int price = Integer.valueOf(req.getParameter("price"));
        int sum = Integer.valueOf(req.getParameter("sum"));
        int buyerid = Integer.valueOf(req.getParameter("buyerid"));
        Order order = new Order(material, num, price, sum, buyerid);
        int i = orderService.insertOrder(order);
        if (i == 1) {
            out.write(JSON.toJSONString("success!"));
        } else {
            out.write(JSON.toJSONString("fail!"));
        }
    }

    //    ????????????????????????
    protected void insertMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String material = req.getParameter("material");
        int num = Integer.valueOf(req.getParameter("num"));
        int price = Integer.valueOf(req.getParameter("price"));
        RawMaterial rawMaterial = new RawMaterial(material, num, price);
        int i = rawMaterialService.insertRawMaterial(rawMaterial);
        if (i == 1) {
            out.write(JSON.toJSONString("success!"));
        } else {
            out.write(JSON.toJSONString("fail!"));
        }
    }

    //    ?????????????????????????????????
    protected void getMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String materialName = req.getParameter("materialName");
//        RawMaterial rawMaterial = new RawMaterial(materialName);
        RawMaterial rawMaterial = rawMaterialService.getRawMaterial(materialName);
        rawMaterial.setNewtime(rawMaterial.getTime().toString());
        out.write(JSON.toJSONString(rawMaterial));
    }

    //    ????????????????????????????????????????????????
    protected void updateMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int newprice = Integer.valueOf(req.getParameter("newprice"));
        String materialname = req.getParameter("materialName");
//        RawMaterial rawMaterial = new RawMaterial(newprice, materialname);
        int i = rawMaterialService.updateRawMaterial(newprice, materialname);
        if (i == 1) {
//            req.getRequestDispatcher("/updateMaterial1").forward(req,resp);
//            out.write(JSON.toJSONString(newprice));
//            System.out.println(newprice);
            out.write(JSON.toJSONString("success!"));
        } else {
            out.write(JSON.toJSONString("fail!"));
        }
    }

    //    ??????????????????????????????????????????????????????????????????
    protected void getMaterialPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String materialName = req.getParameter("materialName");
//        RawMaterial rawMaterialPrice = new RawMaterial(materialName);
        RawMaterial materialByName = rawMaterialService.getRawMaterialPrice(materialName);
        out.write(JSON.toJSONString(materialByName));
    }

    //    ?????????????????????????????????????????????id????????????
    protected void getMaterialId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RawMaterial> rawMaterials = rawMaterialService.getRawMaterialId();
        PrintWriter out = resp.getWriter();
        String materialId = req.getParameter("materialId");
        out.write(JSON.toJSONString(rawMaterials));
    }

    //    ??????????????????????????????
    protected void getOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.getOrder();
        PrintWriter out = resp.getWriter();
        Iterator<Order> iterator = orders.iterator();
        while (iterator.hasNext()) {
            Order next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        out.write(JSON.toJSONString(orders));
    }

    //    ??????????????????id??????
    protected void getOrderById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int orderId = Integer.valueOf(req.getParameter("orderId"));
//        Order orderById = new Order(orderId);
        Order orderById = orderService.getOrderById(orderId);
        orderById.setNewtime(orderById.getTime().toString());
        out.write(JSON.toJSONString(orderById));
    }

    //    ??????????????????????????????
    protected void getOrderByMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderByMaterial = req.getParameter("material");
        List<Order> orders = orderService.getOrderByMaterial(orderByMaterial);
        PrintWriter out = resp.getWriter();
        out.write(JSON.toJSONString(orders));
    }

    //    ????????????????????????????????????
    protected void vagueCheckByMaterial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String material = req.getParameter("material");
        System.out.println(material);
        List<Order> orders = orderService.vagueCheckByMaterial(material);
        System.out.println(orders);
        PrintWriter out = resp.getWriter();
        out.write(JSON.toJSONString(orders));
    }

    //    ??????????????????????????????
    protected void getRawMaterialAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RawMaterial> rawMaterials = rawMaterialService.getRawMaterialAll();
        PrintWriter out = resp.getWriter();
        Iterator<RawMaterial> iterator = rawMaterials.iterator();
        while (iterator.hasNext()) {
            RawMaterial next = iterator.next();
            next.setNewtime(next.getTime().toString());
        }
        out.write(JSON.toJSONString(rawMaterials));
    }

    /* //     ??????????????????????????????????????????????????????????????????????????????
     protected void getOrderAllNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         List<Order> orders = orderService.getOrderAllNum();
         PrintWriter out = resp.getWriter();
         out.write(JSON.toJSONString(orders));
     }*/
    //    ??????????????????????????????
    protected void getRawMaterialName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        String materialname = req.getParameter("materialname");
        //  RawMaterial materialByName = new RawMaterial(materialname);
        RawMaterial materialByName = rawMaterialService.getRawMaterialName(materialname);
        materialByName.setNewtime(materialByName.getTime().toString());
        out.write(JSON.toJSONString(materialByName));
    }

    //    ??????????????????id??????
    protected void getRawMaterialById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int materialId = Integer.valueOf(req.getParameter("materialId"));
        RawMaterial materialById = rawMaterialService.getRawMaterialById(materialId);
        materialById.setNewtime(materialById.getTime().toString());
        out.write(JSON.toJSONString(materialById));
    }

    //    ?????????????????????10???
    protected void getOrderPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        int orderPage = Integer.valueOf(req.getParameter("page"));
//        System.out.println(orderPage);
        List<Order> orderPages = orderService.getOrderPage(orderPage);
//        System.out.println(orderPages);
        out.write(JSON.toJSONString(orderPages));
    }

    //    ??????????????????
    protected void getTotalOrderNum(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        int orderTotalNum = orderService.getTotalOrderNum();
//        System.out.println(orderTotalNum);
        out.write(JSON.toJSONString(orderTotalNum));
    }

    //    ??????????????????
    protected void deleteRawMaterialByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        PrintWriter out = resp.getWriter();
        String materialName = req.getParameter("material");
        int i = rawMaterialService.deleteRawMaterialByName(materialName);
        if (i != 0){
            out.write("success!");
            return;
        }else {
            out.write("fail!");
        }
    }
}
class test{
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl();

        List<Order> orders = orderService.vagueCheckByMaterial("b");
        System.out.println(orders);
//        System.out.println(orderService.getOrderPage(0));
    }
}

