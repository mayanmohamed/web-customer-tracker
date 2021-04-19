package com.luv2code.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Transactional
	@Override
	public List<Customer> getCustomers() {
		
		
		return customerDAO.getCustomers();
	}


	@Transactional
	@Override
	public void saveCustomer(Customer theCustomer) {
		
		customerDAO.saveCustomer(theCustomer);
		
	}


	@Transactional
	@Override
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}


	@Transactional
	@Override
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

}
