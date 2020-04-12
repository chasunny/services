package com.food.my.usermanagement.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.food.my.usermanagement.exception.ResourceNotFoundException;
import com.food.my.usermanagement.model.User;
import com.food.my.usermanagement.repository.UserRepository;
import com.food.my.usermanagement.security.UserPrincipal;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	 @Autowired
	    UserRepository userRepository;

	    @Override
	    @Transactional
	    public UserDetails loadUserByUsername(String email)
	            throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email)
	                .orElseThrow(() ->
	                        new UsernameNotFoundException("User not found with email : " + email)
	        );

	        return UserPrincipal.create(user);
	    }

	    @Transactional
	    public UserDetails loadUserById(Long id) {
	        User user = userRepository.findById(id).orElseThrow(
	            () -> new ResourceNotFoundException("User", "id", id)
	        );

	        return UserPrincipal.create(user);
	    }
}
