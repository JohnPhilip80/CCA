package edu.cca.john.semester.models;

import java.util.HashSet;
import java.util.Set;

public class AppUserDto {
	private Long userid;
	private String name;
	private Long contact;
	private String email;
	private String password;
	private Set<AppRole> userroles = new HashSet<AppRole>();
	public AppUserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppUserDto(String name, Long contact, String email, String password) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}
	public Long getUserid() {
		return userid;
	}
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
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
