package com.example.Restaurante;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	//let s configure paths and routes of my project
	//to define home and hello
	@Override
	public void addViewControllers (ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/createuser").setViewName("createuser.html");
		registry.addViewController("/showQR").setViewName("showQR");
		registry.addViewController("/memory").setViewName("memory.html");
		registry.addViewController("/script.js").setViewName("script.js");
		registry.addViewController("/style.css").setViewName("style.css");
		registry.addViewController("/perfil").setViewName("perfil.html");
		registry.addViewController("/getImage").setViewName("perfil.html");
		registry.addViewController("/hello").setViewName("hello");
		registry.addViewController("/login").setViewName("login.html");
		registry.addViewController("/logout").setViewName("logout");
		
		
		
	}
	

}
