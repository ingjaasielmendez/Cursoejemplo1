package com.example.Restaurante;

public interface QRService {
	
	
	 byte[] generateQRCode(String qrContent, int width, int height);

}