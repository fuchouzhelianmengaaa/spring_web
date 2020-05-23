package com.demo.dao;

import com.demo.beans.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Repository("customerDao")
public class CustomerDaoImp extends BaseDao implements CustomerDao {

    @Override
    public List<CustomerInfo> findAllCustomers() {


//       return super.getJdbcTemplate().query("SELECT c.customer_id,c.first_name,c.last_name,c.dob,c.phone " +
//                "FROM customers c", new ResultSetExtractor<List<CustomerInfo>>() {
//            @Override
//            public List<CustomerInfo> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                List<CustomerInfo> list=new ArrayList<CustomerInfo>();
//                CustomerInfo Info;
//                while (rs.next()){
//                    Info=new CustomerInfo();
//                    Info.setCustomerId(rs.getInt("customer_id"));
//                    Info.setFirstName(rs.getString("first_name"));
//                    Info.setLastName(rs.getString("last_name"));
//                    Info.setDob(rs.getDate("dob"));
//                    Info.setPhone(rs.getString("phone"));
//                    list.add(Info);
//                }
//                return list;
//            }
//        });
       /* final  List<CustomerInfo> list=new ArrayList<>();
       super.getJdbcTemplate().query("SELECT c.customer_id,c.first_name,c.last_name,c.dob,c.phone " +
               "FROM customers c", new RowCallbackHandler() {
           @Override
           public void processRow(ResultSet rs) throws SQLException {
              CustomerInfo Info=new CustomerInfo();
                    Info.setCustomerId(rs.getInt("customer_id"));
                    Info.setFirstName(rs.getString("first_name"));
                    Info.setLastName(rs.getString("last_name"));
                    Info.setDob(rs.getDate("dob"));
                    Info.setPhone(rs.getString("phone"));
                    list.add(Info);

           }
       });
       return  list;*/
       return  super.getJdbcTemplate().query("SELECT c.customer_id,c.first_name,c.last_name,c.dob,c.phone " +
               "FROM customers c", new RowMapper<CustomerInfo>() {
           @Override
           public CustomerInfo mapRow(ResultSet rs, int i) throws SQLException {
               CustomerInfo Info=new CustomerInfo();
               Info.setCustomerId(rs.getInt("customer_id"));
               Info.setFirstName(rs.getString("first_name"));
               Info.setLastName(rs.getString("last_name"));
               Info.setDob(rs.getDate("dob"));
               Info.setPhone(rs.getString("phone"));
               return Info;
           }
       });
    }

    @Override
    @Transactional
    public int saveInfo(CustomerInfo cstInfo) {

      Integer cstId= this.getJdbcTemplate().queryForObject("select ifnull(max(customer_id)+1,1) from customers",Integer.class);

      return this.getJdbcTemplate().update("INSERT INTO customers(customer_id,first_name,last_name,dob,phone) " +
               "VALUES (?,?,?,?,?) ",new Object[]{cstId,cstInfo.getFirstName(),cstInfo.getLastName(),cstInfo.getDob(),cstInfo.getPhone()});
    }
}
