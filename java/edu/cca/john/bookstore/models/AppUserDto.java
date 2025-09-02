package edu.cca.john.bookstore.models;

import java.util.Set;

public class AppUserDto {
	private Long id;
	private String name;
	private String email;
	private String password;
	private Set<AppRole> userroles;
	public AppUserDto(Long id, String name, String email, String password, Set<AppRole> userroles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userroles = userroles;
	}
	public AppUserDto(String name, String email, String password, Set<AppRole> userroles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userroles = userroles;
	}
	public AppUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<AppRole> getUserroles() {
		return userroles;
	}
	public void setUserroles(Set<AppRole> userroles) {
		this.userroles = userroles;
	}
		
		
	
}