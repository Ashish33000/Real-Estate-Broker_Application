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

import com.masai.entity.Authority;
import com.masai.entity.Users;
import com.masai.repository.UserRepository;

public class UsersDetailsService implements UserDetailsService {
   @Autowired
   private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Users> opt=userRepo.findByUserEmail(username);
		if(opt.isPresent()) {
			Users users=opt.get();
			List<GrantedAuthority> authorities=new ArrayList<>();
			List<Authority> auths=users.getAuthorities();
			for(Authority auth:auths) {
				SimpleGrantedAuthority sga=new SimpleGrantedAuthority(auth.getName());
				System.out.println("siga"+sga);
				authorities.add(sga);
			}
			System.out.println("Granted Authorities"+authorities);
			return new User(users.getUserEmail(),users.getUserPassword(),authorities);
		}else {
			throw new BadCredentialsException("userDetail not found with this UserName"+username);
		}
	
	}

}
