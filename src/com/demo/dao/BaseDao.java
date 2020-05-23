package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
