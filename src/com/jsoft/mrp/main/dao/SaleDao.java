package com.jsoft.mrp.main.dao;


import com.jsoft.mrp.main.entity.Sale;

import java.util.List;

public interface SaleDao {
    Sale checkSid(Integer s_id) throws Exception;
    Integer newwrite(Sale sale) throws Exception;
}
