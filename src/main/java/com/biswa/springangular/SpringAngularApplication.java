package com.biswa.springangular;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.biswa.springangular.domains.Role;
import com.biswa.springangular.repository.UserRepository;


@SpringBootApplication
public class SpringAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAngularApplication.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userrepo) throws Exception {
		if (userrepo.count()==0)
			userrepo.save(new com.biswa.springangular.domains.UserDetails("skaterik", "pass", Arrays.asList(new Role("USER"), new Role("ACTUATOR"))));
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username)
					throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return new CustomUserDetails(userrepo.findByUsername(username));
			}
		});
	}
}
