package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by last_name", 
																Customer.class);
		
		// execute query
		List<Customer> customers = theQuery.getResultList();
		
		// return results
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer to the db
		currentSession.save(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int customerId) {
	
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// get customer from the db
		Customer theCustomer = currentSession.get(Customer.class, customerId);
		
		return theCustomer;
	}

}
