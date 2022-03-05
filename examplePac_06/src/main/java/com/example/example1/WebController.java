package com.example.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	@RequestMapping("/mylibrary")
	
	public class WebController {
	@Autowired
	Bookservice bookservice;
	@Autowired
	Authorservice authorservice;
	@Autowired
	BookRepository bookrepository;
	@Autowired
	AuthorRepository authorrepository;
	
	@RequestMapping("/web")
	
	public String getWeb (Model containerToView) {
		
		containerToView.addAttribute("booksfromController", bookrepository.findAll());
		  containerToView.addAttribute("AuthorfromController", authorrepository.findAll());

		System.out.println("Controller Web request  ...");
			
			return "web.html";
		}
}
