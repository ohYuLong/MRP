package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.Finished;

import java.util.List;

public interface FinishedService {
    //查询所有成品
    List<Finished> listFinisheds();



    //模糊查询
    List<Finished> listOnes(String pro);
}
