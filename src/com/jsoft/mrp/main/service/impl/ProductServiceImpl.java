/*
package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.ProductionDao;
import com.jsoft.mrp.main.dao.impl.ProductionDaoImpl;
import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.main.service.ProductService;

public class ProductServiceImpl implements ProductService {
    private ProductionDao p = new ProductionDaoImpl();

    @Override
    public Boolean procuction(Production production) {
        try {
          return p.addProduction(production);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getRawNum(Production production) {
        try {
            return p.RawNum(production);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

*/
