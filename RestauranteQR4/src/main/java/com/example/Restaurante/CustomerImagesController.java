package com.example.Restaurante;
/*
 * import java.io.IOException; import java.util.Base64; import
 * java.util.Base64.Encoder; import java.util.Optional;
 * 
 * import org.bson.types.Binary; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.MediaType; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestParam; import
 * org.springframework.web.multipart.MultipartFile;
 * 
 * import com.example.Restaurante.Clases.CustomerImgQR; import
 * com.example.Restaurante.Repos.CustomerImagesRepository;
 * 
 * @Controller public class CustomerImagesController {
 * 
 * 
 * @Autowired CustomerImagesRepository customerimagesrepository;
 * 
 * @PostMapping("/createCustomerImgQR") public CustomerImgQR createCustomerImgQR
 * (@RequestParam String username, @RequestParam MultipartFile file) throws
 * IOException {
 * 
 * CustomerImgQR customerimages = new CustomerImgQR();
 * customerimages.setUsername(username); customerimages.setImage( new
 * Binary(file.getBytes() ));
 * 
 * customerimagesrepository.save(customerimages);
 * 
 * return customerimages; }
 * 
 * @GetMapping("/getCustomerImgQRData") public String getCustomerImgQRData
 * (@RequestParam String id) {
 * 
 * System.out.println("id..." + id); Optional<CustomerImgQR> customerimage =
 * customerimagesrepository.findById(id); Encoder encoder = Base64.getEncoder();
 * 
 * return encoder.encodeToString( customerimage.get().getImage().getData() ); }
 * 
 * @GetMapping("/getCustomerImgQR") public ResponseEntity<byte[]>
 * getCustomerImgQR (@RequestParam String id) {
 * 
 * Optional<CustomerImgQR> customerimage =
 * customerimagesrepository.findById(id); HttpHeaders headers = new
 * HttpHeaders(); headers.setContentType(MediaType.IMAGE_JPEG);
 * 
 * return new ResponseEntity<>( customerimage.get().getImage().getData(),
 * headers, HttpStatus.OK ); }
 * 
 * }
 */
