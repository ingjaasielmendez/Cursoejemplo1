package com.example.EjemploEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.EjemploEmployee.Servs.AuthorService;
import com.example.EjemploEmployee.Servs.BookService;

@Controller
@RequestMapping("/mylibrary")
public class WebController {

	@Autowired
	BookService bookservice;
	
	@Autowired
	AuthorService authorservice;
	
	
@RequestMapping("/web")
public String getWeb (Model containerToView) {
		
		containerToView.addAttribute("booksfromController", bookservice.findAll());
		  containerToView.addAttribute("AuthorfromController", authorservice.findAll());

		System.out.println("Controller Web request  ...");
			
			return "Employeeweb.html";
		}
	
	
}
