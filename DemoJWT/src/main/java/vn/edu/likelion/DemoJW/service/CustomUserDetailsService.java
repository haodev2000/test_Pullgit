package vn.edu.likelion.DemoJW.service;

import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import vn.edu.likelion.DemoJW.model.Users;
import vn.edu.likelion.DemoJW.repository.UserRepository;


@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
	
	private UserRepository userRepository;
	
	@Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Users user = userRepository.findByUsername(usernameOrEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User not exists by Username or Email"));
//
//        GrantedAuthority authorities = user.getRole().stream()
//                .map((role) -> new SimpleGrantedAuthority(role.getName()))
//                .collect(Collectors.toSet());
        
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getName());
//        Set<GrantedAuthority> authorities = new HashSet<>();
//        authorities.add(authority);
        
        return new org.springframework.security.core.userdetails.User(
                usernameOrEmail,
                user.getPassword(),
                Collections.singleton(authority)
        );


        
//         GrantedAuthority authoritie = new SimpleGrantedAuthority(user.getRole().getName());

//        return new org.springframework.security.core.userdetails.User(
//                usernameOrEmail,
//                user.getPassword(),
//                (Collection<? extends GrantedAuthority>) authoritie
//        );
        
       
    }

}
