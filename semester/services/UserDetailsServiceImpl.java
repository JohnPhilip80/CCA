package edu.cca.john.semester.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cca.john.semester.models.AppUser;
import edu.cca.john.semester.repositories.AppUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private AppUserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load User by Username...");
		AppUser appUser = repo.findByEmail(username);
		return new UserDetailsImpl(appUser);
	}
	
}
