package com.demo.service;

import com.demo.beans.ProductInfo;
import com.demo.mapper.ProductMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.sql.SQLException;
import java.util.List;

@Service("productService")
public class ProductServiceImp implements  ProductService {
    private static Logger logger= Logger.getLogger(ProductServiceImp.class);

    @Value("${db.url}")
    private String url;
    //根据类型自动装配
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<ProductInfo> findAllProducts() throws SQLException {
          logger.debug("++++++++++++++++++++++++++++++++++++++"+url);

            List<ProductInfo> list=null;
            list=this.productMapper.findAllProducts();
            return list;
    }

    @Override
    public boolean saveInfo(ProductInfo prdInfo) {
       return this.productMapper.saveInfo(prdInfo)>0;

    }

    @Override
    public ProductInfo findProductById(Integer prdId) {

        return this.productMapper.findProductById(prdId);
    }
}
