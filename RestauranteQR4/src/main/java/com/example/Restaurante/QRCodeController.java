package com.example.Restaurante;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Clases.CustomerImgQR;
import com.example.Restaurante.Serv.CustomerService;
import com.example.Restaurante.Serv.CustomerServiceImg;
import com.example.Restaurante.Serv.QRService;



@Controller
public class QRCodeController {
	
	@Autowired
	CustomerServiceImg customerserviceimg;
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	QRService qrService;
	
	
	
	@PostMapping("/showQR")
	public String showQR (String qrText, Model model) {
		
		model.addAttribute("qrCodeText", "/createQR?qrText=" + qrText);
		
		return  "qrweb";
		
	}
	
	@GetMapping("/createQR")
	public void createQR (String qrText, HttpServletResponse response) throws IOException {
		
		 response.setContentType("image/png"); 
		
        byte[] qrCode = qrService.generateQRCode(qrText, 200, 200);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(qrCode);
        
        
        CustomerImgQR customerimages = new CustomerImgQR();
        customerimages.setId("1");
        customerimages.setUsername("admin");
		customerimages.setImage( new Binary(qrCode));
		
		customerserviceimg.save(customerimages);
		
		
	}
	
	/*
	 * @GetMapping(path = "/getCustomerImgQR") public Customer
	 * getCustomerImgQR1(String username) throws UsernameNotFoundException { final
	 * Customer customer = customerservice.findByUsername(username); if (customer ==
	 * null) { throw new UsernameNotFoundException(username); } return customer; }
	 * 
	 * 
	 * @GetMapping(path = "/getCustomerImgQR") public CustomerImgQR
	 * getCustomerImgQR2(String username) throws UsernameNotFoundException { final
	 * CustomerImgQR customerimages = customerserviceimg.findByUsername(username);
	 * if(customerimages == null) { throw new UsernameNotFoundException(username); }
	 * return customerimages; }
	 * 
	 * 
	 * 
	 * 
	 * @PostMapping(path = "/getCustomerImgQR") public String Mostrarperfil(Customer
	 * customer, CustomerImgQR customerimages, Model model1, Model model2) {
	 * model1.addAttribute("getCustomerImgQR", customer);
	 * model2.addAttribute("getCustomerImgQR", customerimages); return "perfil"; }
	 */
}