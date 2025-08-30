package edu.cca.john.semester.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cca.john.semester.models.AppUserDto;
import edu.cca.john.semester.models.AuthResponseDto;
import edu.cca.john.semester.models.LoginDto;
import edu.cca.john.semester.services.AuthService;

@RestController
@RequestMapping("/semester/auth/")
public class AuthController {
	@Autowired
	AuthService authService;
	@PostMapping("/register")
	public String registerUser(@RequestBody AppUserDto appUserDto){
		return authService.registerUser(appUserDto);
	}
	@PostMapping("/login")
	public AuthResponseDto authenticateUser(@RequestBody LoginDto loginDto){
			return authService.loginUser(loginDto);
	}
}
