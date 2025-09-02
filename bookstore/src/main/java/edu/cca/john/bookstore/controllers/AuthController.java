package edu.cca.john.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cca.john.bookstore.models.AppUserDto;
import edu.cca.john.bookstore.models.LoginDto;
import edu.cca.john.bookstore.services.AuthService;

@RestController
@RequestMapping("/book/auth/api")
public class AuthController {
	@Autowired
	AuthService authService;
	
	@PostMapping("/register")
	public String registerUser(@RequestBody AppUserDto appUserDto){
		return authService.registerUser(appUserDto);
	}
	@PostMapping("/login")
	public String authenticateUser(@RequestBody LoginDto loginDto){
			return authService.loginUser(loginDto);
	}
}