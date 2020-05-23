package com.demo.dao;

import com.demo.beans.CustomerInfo;

import java.util.List;

public interface CustomerDao {
    public  List<CustomerInfo> findAllCustomers();

    int saveInfo(CustomerInfo cstInfo);
}


