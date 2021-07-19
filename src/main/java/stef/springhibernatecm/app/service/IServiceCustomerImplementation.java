package stef.springhibernatecm.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import stef.springhibernatecm.app.dao.ICustomerDAO;
import stef.springhibernatecm.app.entity.Customer;

@Service
public class IServiceCustomerImplementation implements IServiceCustomer{

	
	@Autowired
	private ICustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDAO.saveCustomer(customer);
	}
}
