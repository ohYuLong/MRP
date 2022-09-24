package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.ProductionDao;
import com.jsoft.mrp.main.dao.impl.ProductionDaoImpl;
import com.jsoft.mrp.main.entity.Production;
import com.jsoft.mrp.main.service.ProductionService;
import com.jsoft.mrp.util.PageDTO;

import java.util.List;

public class ProductionServiceImpl implements ProductionService {
    private ProductionDao productionDao = new ProductionDaoImpl();

    //删除对应的记录
    @Override
    public Integer delectRecord(Integer id) {
        Integer one = null;
        try {
             one = productionDao.delectOne(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return one;
    }

    //模糊查询
    @Override
    public List<Production> listOnes(String pre) {
        List<Production> productions;
        try {
            productions = productionDao.checkOnes(pre);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productions;
    }

    //查询所有
    //service层
    @Override
    public PageDTO<Production> listProduce(Integer currentPage) {
        //每页显示多少条数据(自己规定的)
        Integer pageRecord = 10;//规定每页显示10条记录
        //根据公式 (当前页-1)*每页显示的记录数 可以得出 limit ? ,15 => ? 号的值
        //调用dao层方法 得出总记录数
        PageDTO<Production> pageDTO = null;
        try {
            Long totalRecord = productionDao.checkRecords();
             pageDTO = new PageDTO<>(pageRecord, totalRecord.intValue());
            if(currentPage < 1){
                currentPage = 1;

            }
            if(currentPage > pageDTO.getTotalPage()){
                currentPage = pageDTO.getTotalPage();
            }
            Integer startPage =(currentPage -1) * pageRecord;// 得出?号的值
            List<Production> productions = productionDao.checkAll(startPage, pageRecord);
            pageDTO.setContent(productions);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pageDTO;
    }
}

