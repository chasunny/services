package com.food.my.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.my.usermanagement.exception.ResourceNotFoundException;
import com.food.my.usermanagement.model.User;
import com.food.my.usermanagement.repository.UserRepository;
import com.food.my.usermanagement.security.CurrentUser;
import com.food.my.usermanagement.security.UserPrincipal;


@RestController
public class UserController {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }

}
