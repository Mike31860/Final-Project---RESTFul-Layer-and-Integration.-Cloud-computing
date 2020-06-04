package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.DAOS.AdminDao;
import com.example.demo.Model.TsscAdmin;
import com.example.demo.Repository.AdminRepository;


@Service
public class MyCustomUserDetailsService implements UserDetailsService {
	
	
	
	private AdminDao usuarios;
	
	
	@Autowired
	public MyCustomUserDetailsService(AdminDao usuarios) {
		super();
		this.usuarios = usuarios;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TsscAdmin userApp = usuarios.findByUser(username);
		if (userApp != null) {
			User.UserBuilder builder = User.withUsername(username).password(userApp.getPassword()).roles(userApp.getSuperAdmin());
			return builder.build();
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
	}
}