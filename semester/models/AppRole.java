package edu.cca.john.semester.models;

import jakarta.persistence.Column;
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
	@Column(length=20)
	private ERole name;
	private String description;
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



	public AppRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getName() {
		return name.toString();
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
