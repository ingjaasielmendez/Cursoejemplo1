package com.example.Restaurante;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Restaurante.Serv.QRService;

@Controller
public class QRCodeController {
	
	@Autowired
	public  QRService qrService;
	
	
	
	
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
		
		
	}
	

}