package com.demo.service;

import com.demo.beans.CustomerInfo;
import com.demo.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service("customerService")
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @Override
    @Transactional(readOnly = true)
    public List<CustomerInfo> findAllCustomers() {
        return this.customerDao.findAllCustomers();
    }

    @Override
    public boolean saveInfo(CustomerInfo cstInfo) {
        return this.customerDao.saveInfo(cstInfo)>0;
    }
}
