package edu.cca.john.semester.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.cca.john.semester.models.AppUser;

public class UserDetailsImpl implements UserDetails{
	private static final long serialVersionUID = 7577777170321511444L;
	private AppUser appUser;
	
	public UserDetailsImpl(AppUser appUser) {
		super();
		this.appUser = appUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = appUser.getUserroles().stream().map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return authorities;
	}

	@Override
	public String getPassword() {
		System.out.println("Getting Password...");
		return appUser.getPassword();
	}

	@Override
	public String getUsername() {
		System.out.println("Getting Username...");
		return appUser.getName();
	}

}
