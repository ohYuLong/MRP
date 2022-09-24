package com.jsoft.mrp.main.dao.impl;


import com.jsoft.mrp.main.dao.RawMaterialDao;
import com.jsoft.mrp.main.entity.RawMaterial;
import com.jsoft.mrp.util.DAOImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class RawMaterialDaoImpl extends DAOImpl<RawMaterial> implements RawMaterialDao {
    //    原料表中新增一条记录
    @Override
    public int addRawMaterial(RawMaterial rawMaterial) throws Exception {
        String sql = "insert into `rawmaterial` (material,num,price,time) values (?,?,?,?)";
        Date date = new Date();//获得当前时间
        Timestamp t = new Timestamp(date.getTime());
        return update(sql,rawMaterial.getMaterial(),rawMaterial.getNum(),rawMaterial.getPrice(),t);
    }
    //    原料表：根据原料名查询
    @Override
    public RawMaterial getRawMaterial(String rawMaterialName) throws Exception {
        String sql = "select * from `rawmaterial` where material = ? GROUP BY material";
         return get(sql,rawMaterialName);
    }
    //    原料表：修改价格
    @Override
    public int updateRawMaterial(Integer rawMaterialPrice,String rawMaterialName) throws Exception {
        String sql = "update `rawmaterial` set price = ? where material = ?";
        return update(sql,rawMaterialPrice,rawMaterialName);
    }
    //    原料表：查询原料表的价格在addOrder中动态获取价格
    @Override
    public RawMaterial getRawMaterialPrice(String materialName) throws Exception {
        String sql = "select material,price from `rawmaterial` where material = ?";
        return get(sql,materialName);
    }
    //    原料表：动态获取原料名
    @Override
    public List<RawMaterial> getRawMaterialId() throws Exception {
        String sql = "select * from `rawmaterial`";
        List<RawMaterial> forList = getForList(sql);
        return forList;
    }
    //    原料表：查询所有
    @Override
    public List<RawMaterial> getRawMaterialAll() throws Exception {
        String sql = "select * from `rawmaterial` order by material";
        List<RawMaterial> forList = getForList(sql);
        return forList;
    }
    //    根据名字查询
    @Override
    public RawMaterial getRawMaterialName(String rawMaterial) throws Exception {
        String sql = "select * from `rawmaterial` where material = ?";
        return get(sql,rawMaterial);
    }
    //    根据id查询
    @Override
    public RawMaterial getRawMaterialById(Integer id) throws Exception {
        String sql = "select * from `rawmaterial` where id = ?";
        return get(sql,id);
    }
    //    订单表增加一条数据时原料表的数量回随着增加变化
    @Override
    public int updateRawMaterialNum(String material, Integer number) throws Exception {
        String sql = "UPDATE rawmaterial set num = num + ?  where material = ?";
        return update(sql,number,material);
    }

    //    删除原料
    @Override
    public int deleteRawMaterialByName(String material) throws Exception {
        String sql = "delete from `rawmaterial` where material = ?";
        return update(sql,material);

    }
}
