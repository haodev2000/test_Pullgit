package vn.edu.likelion.DemoJW.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	  private String usernameOrEmail;
	    private String password;
}
