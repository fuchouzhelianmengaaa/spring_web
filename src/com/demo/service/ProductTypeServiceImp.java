package com.demo.service;

import com.demo.beans.ProductTypeInfo;
import com.demo.mapper.ProductTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("productTypeService")
public class ProductTypeServiceImp implements ProductTypeService {
    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductTypeInfo> findAllTypes() {
       return productTypeMapper.findAllTypes();

    }
}
