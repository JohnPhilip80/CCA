package edu.cca.john.bookstore.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role")
public class AppRole {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleid;
	@Enumerated(EnumType.STRING)
	private ERole name;
	private String description;
	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppRole(Long roleid, ERole name, String description) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.description = description;
	}
	public AppRole(ERole name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public ERole getName() {
		return name;
	}
	public void setName(ERole name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
		
}