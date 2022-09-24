package com.jsoft.mrp.main.service.impl;

import com.jsoft.mrp.main.dao.FinishedDao;
import com.jsoft.mrp.main.dao.impl.FinishedDaoImpl;
import com.jsoft.mrp.main.entity.Finished;
import com.jsoft.mrp.main.service.FinishedService;

import java.util.List;

public class FinishedServiceImpl implements FinishedService {
    private FinishedDao finishedDao = new FinishedDaoImpl();

    @Override
    public List<Finished> listOnes(String pro) {
        List<Finished> finisheds = null;
        try {
            finisheds = finishedDao.checkOnes(pro);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return finisheds;
    }

    //service层
    //查询所有
    @Override
    public List<Finished> listFinisheds() {

        List<Finished> finisheds = null;
        try {
             finisheds = finishedDao.checkAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return finisheds;
    }
}

//class test{
//    public static void main(String[] args) {
//        FinishedService finishedService = new FinishedServiceImpl();
//        List<Finished> finisheds = finishedService.listFinisheds();
//        System.out.println(finisheds);
//    }
//}