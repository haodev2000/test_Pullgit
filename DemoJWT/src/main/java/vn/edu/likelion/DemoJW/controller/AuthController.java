package vn.edu.likelion.DemoJW.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import vn.edu.likelion.DemoJW.model.JwtAuthResponse;
import vn.edu.likelion.DemoJW.model.LoginDto;
import vn.edu.likelion.DemoJW.service.AuthService;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth") 
@CrossOrigin
public class AuthController {

	  private AuthService authService;

	    // Build Login REST API
	    @PostMapping("/login")
	    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto){
	    	System.out.println("Clmmmmmmmmmmmmmmm");
	        String token = authService.login(loginDto);

	        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
	        jwtAuthResponse.setAccessToken(token);

	        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
	    }
	    
	
	
}
