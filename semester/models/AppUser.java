package edu.cca.john.semester.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class AppUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userid;
	private String name;
	private Long contact;
	private String email;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="userid"),inverseJoinColumns = @JoinColumn(name="roleid"))
	private Set<AppRole> userroles = new HashSet<AppRole>();
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppUser(Long userid, String name, Long contact, String email, String password,
			Set<edu.cca.john.semester.models.AppRole> userroles) {
		super();
		this.userid = userid;
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.password = password;
		this.userroles = userroles;
	}
	
	public AppUser(String name, Long contact, String email, String password) {
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
