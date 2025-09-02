package edu.cca.john.bookstore.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class AppUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_roles",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="roleid"))
	private Set<AppRole> userroles = new HashSet<AppRole>();

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(Long id, String name, String email, String password, Set<AppRole> userroles) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userroles = userroles;
	}

	public AppUser(String name, String email, String password, Set<AppRole> userroles) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userroles = userroles;
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