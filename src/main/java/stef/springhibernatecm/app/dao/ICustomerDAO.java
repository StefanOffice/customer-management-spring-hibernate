package stef.springhibernatecm.app.dao;

import java.util.List;

import stef.springhibernatecm.app.entity.Customer;

public interface ICustomerDAO {

	public List<Customer> getCustomers();
}
