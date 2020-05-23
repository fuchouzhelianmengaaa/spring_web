package com.demo.mapper;

import com.demo.beans.ProductInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Date 2020/3/29 11:40
 * @Created by sibingmao
 */
public interface ProductMapper {
    List<ProductInfo> findAllProducts() throws SQLException;

    int saveInfo(ProductInfo prdInfo);

    ProductInfo findProductById(Integer prdId);
}
