package com.example.Restaurante;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Restaurante.Clases.Customer;
import com.example.Restaurante.Clases.CustomerImgQR;
import com.example.Restaurante.Repos.CustomerImagesRepository;
import com.example.Restaurante.Serv.CustomerService;
import com.example.Restaurante.Serv.QRService;



@Controller
public class QRCodeController {
	
	
	
	@Autowired
	CustomerService customerservice;
	
	@Autowired
	CustomerImagesRepository customerimagesrepository;
	
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
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        String username = user.getUsername();
        Customer customer = customerservice.findByUsername(username);
        Long id = customer.getId();
        CustomerImgQR customerimages = new CustomerImgQR();
        customerimages.setId(id);
        customerimages.setUsername(username);
		customerimages.setImage( new Binary(qrCode));
		
		customerimagesrepository.save(customerimages);
		
		
	}
	  
	 
	
	  @PostMapping("/perfil") 
	  public Customer Mostrarperfil(@ModelAttribute String username, Model model) {
		  Customer customer = customerservice.findByUsername(username);
		  model.addAttribute("customer", customer);
	      
	  
	  return customer; }
	  
	
	  @GetMapping("/getImage")
		public ResponseEntity<byte[]> getImage (@RequestParam String username) {
			
			Optional<CustomerImgQR> customerimages = customerimagesrepository.findByUsername(username);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			
			return new ResponseEntity<>( customerimages.get().getImage().getData(), headers, HttpStatus.OK );
		}
	 
}