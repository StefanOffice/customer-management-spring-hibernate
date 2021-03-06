package stef.springhibernatecm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stef.springhibernatecm.app.dao.ICustomerDAO;
import stef.springhibernatecm.app.entity.Customer;
import stef.springhibernatecm.app.service.IServiceCustomer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	/**
	 * - no longer required as controller now communicates with service not with the
	 * DAO directyl //inject the customerDAO
	 * 
	 * @Autowired private ICustomerDAO customerDAO;
	 */

	@Autowired
	private IServiceCustomer customerService;

	@GetMapping("/list")
	public String listCustomers(Model model) {

		/**
		 * //get the customers from dao List<Customer> customers =
		 * customerDAO.getCustomers();
		 **/

		// now we get the list from the service instead which redirects the call to DAO
		List<Customer> customers = customerService.getCustomers();

		// add the customers to the model
		model.addAttribute("customers", customers);

		return "customers-list";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create a new object to store the information the user enters
		Customer customer = new Customer();
		model.addAttribute("customer", customer);

		return "customer-form";
	}

	/**
	 * <form:form action="saveCustomer" modelAttribute="customer" method="POST">
	 */
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}
	
	/**
	 <c:param name="customerId" value="${tempCustomer.id}" />
	 that's what the first param is requesting
	 */
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int id, Model model) {
		//get the customer from our service
		Customer customer = customerService.getCustomer(id);
		
		//set customer as a model attribute to pre-populate the form
		model.addAttribute("customer", customer);
		
		//send over to the form
		return "customer-form";
		
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id) {
		customerService.deleteCustomer(id);
		
		return "redirect:/customer/list";
	}
	

}
