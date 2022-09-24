package com.jsoft.mrp.main.service.impl;


import com.jsoft.mrp.main.dao.RawMaterialDao;
import com.jsoft.mrp.main.dao.impl.RawMaterialDaoImpl;
import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.main.service.RawMaterialService;

import java.util.List;

public class RawMaterialServiceImpl implements RawMaterialService {
    private RawMaterialDao dao = new RawMaterialDaoImpl();
    @Override
    public int insertRawMaterial(RawMaterial rawMaterial) {
        try {
            return dao.addRawMaterial(rawMaterial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public RawMaterial getRawMaterial(String rawMaterialName) {
        try {
            return dao.getRawMaterial(rawMaterialName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int updateRawMaterial(Integer rawMaterialPrice,String rawMaterialName) {
        try {
            return dao.updateRawMaterial(rawMaterialPrice,rawMaterialName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public RawMaterial getRawMaterialPrice(String materialName) {
        try {
            return dao.getRawMaterialPrice(materialName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<RawMaterial> getRawMaterialId() {
        List<RawMaterial> rawMaterials = null;
        try {
            return rawMaterials = dao.getRawMaterialId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public List<RawMaterial> getRawMaterialAll() {
        List<RawMaterial> rawMaterials = null;
        try {
            return rawMaterials = dao.getRawMaterialAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public RawMaterial getRawMaterialName(String rawMaterial) {
        try {
            return dao.getRawMaterialName(rawMaterial);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public RawMaterial getRawMaterialById(Integer id) {
        try {
            return dao.getRawMaterialById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int deleteRawMaterialByName(String material) {
        try {
            return dao.deleteRawMaterialByName(material);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
