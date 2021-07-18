package stef.springhibernatecm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import stef.springhibernatecm.app.dao.ICustomerDAO;
import stef.springhibernatecm.app.entity.Customer;
import stef.springhibernatecm.app.service.IServiceCustomer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	/** - no longer required as controller now communicates with service
	 * not with the DAO directyl
	//inject the customerDAO
	@Autowired
	private ICustomerDAO customerDAO;
	*/
	
	@Autowired
	private IServiceCustomer customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		/**
		//get the customers from dao
		List<Customer> customers = customerDAO.getCustomers();
		**/
		
		//now we get the list from the service instead which redirects the call to DAO
		List<Customer> customers = customerService.getCustomers();
		
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "customers-list";
	}
	

}
