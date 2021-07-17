package stef.springhibernatecm.app.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import stef.springhibernatecm.app.entity.Customer;

@Repository
public class CustomerDAOImplementation implements ICustomerDAO{
	
		//injecting the session factory
		@Autowired
		private SessionFactory sessionFactory;
		
		
		@Override
		@Transactional //this annotation automatically creates and commits a transaction
		public List<Customer> getCustomers() {
			//get the current hibernate session
			Session session = sessionFactory.getCurrentSession();
			//create a query using HQL (hibernate query language very similar to SQL)
			Query<Customer> theQuery = session.createQuery("from Customer", Customer.class);
			//execute the query and get the result list
			List<Customer> customers = theQuery.getResultList();
			//return the results
			return customers;
		}

}
