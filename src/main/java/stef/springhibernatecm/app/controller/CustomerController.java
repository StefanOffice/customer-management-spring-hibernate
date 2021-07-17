package stef.springhibernatecm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import stef.springhibernatecm.app.dao.ICustomerDAO;
import stef.springhibernatecm.app.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject the customerDAO
	@Autowired
	private ICustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		//get the customers from dao
		List<Customer> customers = customerDAO.getCustomers();
		
		//add the customers to the model
		model.addAttribute("customers", customers);
		
		return "customers-list";
	}
	

}
