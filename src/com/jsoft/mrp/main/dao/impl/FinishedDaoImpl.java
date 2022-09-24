package com.jsoft.mrp.main.dao.impl;

import com.jsoft.mrp.main.dao.FinishedDao;
import com.jsoft.mrp.main.entity.Finished;
import com.jsoft.mrp.util.DAOImpl;

import java.util.List;

public class FinishedDaoImpl extends DAOImpl<Finished> implements FinishedDao {
    //模糊查询
    @Override
    public List<Finished> checkOnes(String pro) throws Exception {
        String sql = "select * from finished where product like \""+ pro +"%\"";
        List<Finished> lists = getForList(sql);
        return lists;
    }

    @Override
    public List<Finished> checkAll() throws Exception {
        String sql = "select * from finished order by time desc ";
        List<Finished> finisheds = getForList(sql);
        return finisheds;
    }
}
