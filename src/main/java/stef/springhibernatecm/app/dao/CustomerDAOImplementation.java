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
		// @Transactional - no longer necessary here 
		// as it's moved over to the service layer in IServiceCustomerImplementation
		public List<Customer> getCustomers() {
			//get the current hibernate session
			Session session = sessionFactory.getCurrentSession();
			//create a query using HQL (hibernate query language very similar to SQL)
			Query<Customer> theQuery = session.createQuery("from Customer order by lastName", Customer.class);
			//execute the query and get the result list
			List<Customer> customers = theQuery.getResultList();
			//return the results
			return customers;
		}
		
		@Override
		public void saveCustomer(Customer customer) {
			
			Session session = sessionFactory.getCurrentSession();
			//now this method can be used for both saving and updating
			session.saveOrUpdate(customer);
			
		}

		@Override
		public Customer getCustomer(int id) {
			//get the current session
			Session session = sessionFactory.getCurrentSession();
			//read from database using the primary key
			return session.get(Customer.class, id);
		}
		
		@Override
		public void deleteCustomer(int theId) {
			Session session = sessionFactory.getCurrentSession();
			Customer customer = session.get(Customer.class, theId);
			session.delete(customer);
			
			//or
			/**
			Query query = session.createQuery("delete from Customer where id=:theId");
			query.setParameter("customerId", theId);
			query.executeUpdate();
			**/
		}

}
