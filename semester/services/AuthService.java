package edu.cca.john.semester.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.cca.john.semester.models.AppRole;
import edu.cca.john.semester.models.AppUser;
import edu.cca.john.semester.models.AppUserDto;
import edu.cca.john.semester.models.AuthResponseDto;
import edu.cca.john.semester.models.ERole;
import edu.cca.john.semester.models.LoginDto;
import edu.cca.john.semester.repositories.AppRoleRepository;
import edu.cca.john.semester.repositories.AppUserRepository;

@Service
public class AuthService {
	@Autowired
	private AppUserRepository repo;
	@Autowired
	private AppRoleRepository roleRepo;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String registerUser(AppUserDto appUserDto) {
		if(repo.existsByEmail(appUserDto.getEmail())) {
			return "Error: Email Already taken!";
		}
		AppUser appUser = new AppUser(appUserDto.getName(),appUserDto.getContact(),appUserDto.getEmail(),appUserDto.getPassword());
		appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
		Set<AppRole> appRoles = new HashSet<>();
		appRoles.add(roleRepo.getAppRoleByName(ERole.ROLE_STUDENT));
		appUser.setUserroles(appRoles);
		repo.save(appUser);
		return "Student Registered Successfully";
	}
	public AuthResponseDto loginUser(LoginDto loginDto) {
		System.out.println("Testing...");
		AuthResponseDto authResponse = new AuthResponseDto();
		try {
			SecurityContextHolder.getContext().setAuthentication(authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())));
			AppUser appUser = repo.findByEmail(loginDto.getEmail());
			//UserDetailsImpl appUserDetailImpl = new UserDetailsImpl(appUser);
			authResponse.setUserName(appUser.getName());
			authResponse.setUserEmail(appUser.getEmail());
			authResponse.setStatusCode(200);
			authResponse.setUserRoles(appUser.getUserroles());
			authResponse.setMessage("Successfully Logged In!");
		}
		catch(Exception e) {
			authResponse.setStatusCode(500);
			authResponse.setMessage(e.getMessage());
		}
		return authResponse;
	}
}
