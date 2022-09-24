package com.jsoft.mrp.main.service;


import com.jsoft.mrp.main.entity.RawMaterial;

import java.util.List;

public interface RawMaterialService {
    int insertRawMaterial(RawMaterial rawMaterial);

    RawMaterial getRawMaterial(String rawMaterialName);

    int updateRawMaterial(Integer rawMaterialPrice,String rawMaterialName);

    RawMaterial getRawMaterialPrice(String materialName);

    List<RawMaterial> getRawMaterialId();

    List<RawMaterial> getRawMaterialAll();
    RawMaterial getRawMaterialName(String rawMaterial);
    RawMaterial getRawMaterialById(Integer id);
    int deleteRawMaterialByName(String material);
}
