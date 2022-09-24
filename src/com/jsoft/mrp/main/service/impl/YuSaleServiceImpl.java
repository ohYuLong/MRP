package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.YuFinishedDao;
import com.jsoft.mrp.main.dao.YuSaleDao;
import com.jsoft.mrp.main.dao.impl.YuFinishedDaoImpl;
import com.jsoft.mrp.main.dao.impl.YuSaleDaoImpl;
import com.jsoft.mrp.main.entity.YuSale;
import com.jsoft.mrp.main.service.YuSaleService;

import java.util.Date;
import java.util.List;

public class YuSaleServiceImpl implements YuSaleService {
    private YuSaleDao saleManageDao = new YuSaleDaoImpl();
    private YuFinishedDao finishedDao = new YuFinishedDaoImpl();
    //查询所有历史记录
    @Override
    public List<YuSale> checkAll(Integer page) {
        Integer perPageNum = 10;
        Integer p =(page -1)*perPageNum;//第几页 得出 limit ？，10 中的问号
        try {
        return saleManageDao.searchHistories(p, perPageNum);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //往销售表里插入一条数据
    @Override
    public Integer insert(YuSale sale) {
        try {
            Integer integer = finishedDao.updateNumByPname(sale.getProduct(), sale.getNum());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sale.setTime(new Date());
        Integer i = null;
        try {
             i = saleManageDao.update(sale);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  i;
    }


}
// class test{
//     public static void main(String[] args) {
//         SaleManageServiceImpl saleManageService = new SaleManageServiceImpl();
//         String price = saleManageService.checkPrice("p1");
//         System.out.println(price);
//     }
// }