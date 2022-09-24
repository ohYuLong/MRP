package com.jsoft.mrp.main.service;



import com.jsoft.mrp.main.entity.RawMaterial;

import java.util.List;

//业务层 实现功能一层 注意：查询所有
public interface MaterialService {
//查询所有功能(业务)
    List<RawMaterial> listMaterials();


}
