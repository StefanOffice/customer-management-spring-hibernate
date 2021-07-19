package stef.springhibernatecm.app.service;

import java.util.List;
import stef.springhibernatecm.app.entity.Customer;


//This class is an example of a service facade design pattern
//It adds another layer to the app architecture 
// IServiceCustomer is now in charge of connecting one (or multiple DAO's to the controller)
//it will not be of much use in this application, 
//As only one DAO (CustomerDAO) is used within the app 
//But i am adding it as a demonstration to how it would be done if the app used more DAO's
public interface IServiceCustomer {
	
	public List<Customer> getCustomers();
	
	public void saveCustomer(Customer customer);
	
}
