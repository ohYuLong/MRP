package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.MaterialDao;
import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.util.DAOImpl;


import java.util.List;

public class MaterialDaoImpl extends DAOImpl<RawMaterial> implements MaterialDao {
    @Override
    public List<RawMaterial> checkAll() throws Exception {
//查询所有
        String sql = "select * from rawmaterial order by time  desc";
        //RawMaterial rawMaterial = get(sql, material);
         List<RawMaterial> materials = getForList(sql);
         //List<RawMaterial> list=new LinkedList<>();
        return materials;
    }

}

