package com.jsoft.mrp.main.service;

import com.jsoft.mrp.main.entity.Production;

public interface ProductService {
    Boolean procuction(Production production);
    int getRawNum(Production production);
}
