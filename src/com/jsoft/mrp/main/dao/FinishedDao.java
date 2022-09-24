package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.Finished;

import java.util.List;

public interface FinishedDao {
    List<Finished> checkAll() throws Exception;

    //模糊查询
    List<Finished> checkOnes(String pro) throws Exception;
}
