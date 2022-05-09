package com.example.Restaurante.Serv;

public interface QRService {
	
	
	 byte[] generateQRCode(String qrContent, int width, int height);

}