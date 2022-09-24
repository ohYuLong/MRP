package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.RawMaterial;

import java.util.List;

public interface RawMaterialDao {
    //    原料表中新增一条记录
    int addRawMaterial(RawMaterial rawMaterial) throws Exception;
    //    原料表：根据原料名查询价格
    RawMaterial getRawMaterial(String rawMaterialName) throws Exception;
    //    原料表：修改价格
    int updateRawMaterial(Integer rawMaterialPrice,String rawMaterialName) throws Exception;
    //    原料表：查询原料表的价格在addOrder中动态获取价格
    RawMaterial getRawMaterialPrice(String materialName) throws Exception;
    //    原料表：动态获取原料名
    List<RawMaterial> getRawMaterialId() throws Exception;
    //    原料表：查询所有
    List<RawMaterial> getRawMaterialAll() throws Exception;
    //    根据名字查询
    RawMaterial getRawMaterialName(String rawMaterial) throws Exception;
    //    根据id查询
    RawMaterial getRawMaterialById(Integer id) throws Exception;
    //    订单表增加一条数据时原料表的数量回随着增加变化
    int updateRawMaterialNum(String material,Integer number) throws Exception;
    //    删除一个原料
    int deleteRawMaterialByName(String material) throws Exception;
}
