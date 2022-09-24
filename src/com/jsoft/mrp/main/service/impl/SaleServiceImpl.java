/*
package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.FinishedDao;
import com.jsoft.mrp.main.dao.SaleDao;
import com.jsoft.mrp.main.dao.impl.FinishedDaoImpl;
import com.jsoft.mrp.main.dao.impl.SaleDaoImpl;
import com.jsoft.mrp.main.entity.Sale;
import com.jsoft.mrp.main.service.SaleService;
import com.jsoft.mrp.util.DAOImpl;

import java.util.Date;
import java.util.List;

public class SaleServiceImpl extends DAOImpl<Sale> implements SaleService {
    SaleDao saleDao = new SaleDaoImpl();
    @Override
    public Sale listSile(Integer s_id)  {
        Sale sale = null;
        try {
             sale = saleDao.checkSid(s_id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  sale;
    }



    @Override
    public Integer listwrite(Sale sale) {
    FinishedDao finishedDao = new FinishedDaoImpl();
    sale.setTime(new Date());
        try {
            finishedDao.addnum(sale.getProduct(),sale.getTime(),sale.getNum());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Integer newwrite = 0;
        try {
            newwrite = saleDao.newwrite(sale);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newwrite;
    }


}
*/
