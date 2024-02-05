package com.jobhub.dao.customer.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jobhub.dao.customer.CustomerDAO;
import com.jobhub.dto.customer.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Customer> findCustomerList() {
		// TODO Auto-generated method stub
		
		List<Customer> customerList = sqlSessionTemplate.selectList("user_mapper.findCustomerList");
		
		return customerList;
	}
	@Override
	public int saveUser(Customer customer) {
		// TODO Auto-generated method stub
		
		int result = sqlSessionTemplate.insert("login_mapper.saveUser", customer);
		return result;
	}

	@Override
	public Customer findLoginCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer loginCustomer = sqlSessionTemplate.selectOne("user_mapper.findLoginCustomer", customer);
		return loginCustomer;
	}


}


