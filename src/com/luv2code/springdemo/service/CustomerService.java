package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int customerId);

	public void saveCustomer(Customer theCustomer);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String theSearchName);
	
}
