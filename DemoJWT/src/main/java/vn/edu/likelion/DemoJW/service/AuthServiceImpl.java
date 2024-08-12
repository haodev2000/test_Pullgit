package vn.edu.likelion.DemoJW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import vn.edu.likelion.DemoJW.jwt.JwtTokenProvider;
import vn.edu.likelion.DemoJW.model.LoginDto;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

	private AuthenticationManager authenticationManager;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;

    @Override
    public String login(LoginDto loginDto) {
    	
    	 try {
    	        Authentication authentication = authenticationManager.authenticate(
    	                new UsernamePasswordAuthenticationToken(
    	                        loginDto.getUsernameOrEmail(), loginDto.getPassword()));

    	        SecurityContextHolder.getContext().setAuthentication(authentication);
    	        return jwtTokenProvider.generateToken(authentication);
    	    } catch (AuthenticationException ex) {
    	        throw new BadCredentialsException("Invalid username or password");
    	    }

       
    }
	
}
