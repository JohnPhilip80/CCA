package edu.cca.john.bookstore.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cca.john.bookstore.jwt.JWTUtils;
import edu.cca.john.bookstore.models.AppRole;
import edu.cca.john.bookstore.models.AppUser;
import edu.cca.john.bookstore.models.AppUserDto;
import edu.cca.john.bookstore.models.AppUserPrincipal;
import edu.cca.john.bookstore.models.AuthResponseDto;
import edu.cca.john.bookstore.models.ERole;
//import edu.cca.john.bookstore.models.AppUserPrincipal;
import edu.cca.john.bookstore.models.LoginDto;
import edu.cca.john.bookstore.models.MyUserDetailsRepository;
import edu.cca.john.bookstore.repositories.RoleRepository;
@Service
public class AuthService {
	@Autowired
	MyUserDetailsRepository repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private RoleRepository appRoleRepository;
	@Autowired
	private JWTUtils jwtUtils;
	
	public String registerUser(AppUserDto appUserDto){
		
		AppUser appUser = new AppUser();
		appUser.setName(appUserDto.getName());
		appUser.setEmail(appUserDto.getEmail());
		appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
		Set<AppRole> appRoles = new HashSet<>();
		appRoles.add(appRoleRepository.getAppRoleByName(ERole.ROLE_USER));
		appUser.setUserroles(appRoles);
		repo.save(appUser);
		return "User Registered Successfully!";
	}
	
	public AuthResponseDto loginUser(LoginDto loginDto) {
		AuthResponseDto response = new AuthResponseDto();
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserEmail(),loginDto.getUserPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getUserEmail(), loginDto.getUserPassword()));
			AppUser appUser = repo.getAppUserByEmail(loginDto.getUserEmail());
			AppUserPrincipal appUserDetailImpl = new AppUserPrincipal(appUser);
			String jwt = jwtUtils.generateToken(appUserDetailImpl);
			String refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), appUserDetailImpl);
			response.setUserName(appUser.getName());
			response.setUserRoles(appUser.getUserroles());
			response.setStatusCode(200);
			response.setToken(jwt);
			response.setRefreshToken(refreshToken);
			response.setExpirationTime("24Hrs");
			response.setMessage("Successfully Logged In");
		}catch(Exception e) {
			response.setStatusCode(500);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
}