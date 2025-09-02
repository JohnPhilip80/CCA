package edu.cca.john.bookstore.models;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AppUserPrincipal implements UserDetails {
	private static final long serialVersionUID = -6233677962218630384L;
	private AppUser appUser;
	
	public AppUserPrincipal(AppUser appUser) {
		this.appUser = appUser;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//return Collections.singleton(new SimpleGrantedAuthority("USER"));
		List<GrantedAuthority> authorities = appUser.getUserroles().stream().map(role->new SimpleGrantedAuthority(role.getName().toString())).collect(Collectors.toList());
		return authorities;
	}
	@Override
	public String getPassword() {
		return appUser.getPassword();
	}
	@Override
	public String getUsername() {
		return appUser.getEmail();
	}
}
