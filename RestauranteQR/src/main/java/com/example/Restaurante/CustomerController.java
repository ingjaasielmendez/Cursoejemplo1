package com.example.Restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Serv.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	CustomerService customerservice;
	
	
	@GetMapping("/createuser")
	  public String greetingForm(Model model) {
	    model.addAttribute("createuser", new Customer());
	    return "createuser";
	  }
	
	
	@PostMapping(path ="/createuser")
	  public String createSubmit(@ModelAttribute Customer customer, Model model) {
	    model.addAttribute("createuser", customer);
	    customer = customerservice.check(customer);
	    return "result";
	    
	  }
	
}
	
