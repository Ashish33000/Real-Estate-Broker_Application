package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.masai.entity.Users;
import com.masai.repository.UserRepository;
@Service
public class UsersDetailsService implements UserDetailsService {
   @Autowired
   private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> opt=userRepo.findByUserEmail(username);
		if(opt.isPresent()) {
			Users users=opt.get();
			List<GrantedAuthority> authority=new ArrayList<>();
			SimpleGrantedAuthority sga=new SimpleGrantedAuthority(users.getRole());
			authority.add(sga);
	
			return new User(users.getUserEmail(),users.getUserPassword(),authority);
		
			
		}else {
			throw new BadCredentialsException("User is not found with this Username: "+username);
		}
	
	}

}
