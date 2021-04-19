package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImp implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = session.createQuery("from Customer order by lastName" ,Customer.class );
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, theId);
		
		return customer;
	}


	@Override
	public void deleteCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		Customer theCustomer = session.get(Customer.class, theId);
		
		session.delete(theCustomer);
	}

	
	
}
