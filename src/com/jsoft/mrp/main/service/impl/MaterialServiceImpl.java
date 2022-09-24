package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.MaterialDao;
import com.jsoft.mrp.main.dao.impl.MaterialDaoImpl;
import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.main.service.MaterialService;

import java.util.List;

public class MaterialServiceImpl implements MaterialService {
    private MaterialDao materialDao = new MaterialDaoImpl();

    @Override
    public List<RawMaterial> listMaterials() {

        List<RawMaterial> materials =null;
        try {

             materials = materialDao.checkAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    return materials;
    }
}

//class test{
//    public static void main(String[] args) {
//
//        MaterialService materialService = new MaterialServiceImpl();
//        List<RawMaterial> materials = materialService.listMaterials();
//        System.out.println(materials);
//
//
//    }
//}