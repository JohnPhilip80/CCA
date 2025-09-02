package edu.cca.john.bookstore.models;

public class AppRoleDto {
	private Long roleid;
	private ERole name;
	private String description;
	public AppRoleDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppRoleDto(Long roleid, ERole name, String description) {
		super();
		this.roleid = roleid;
		this.name = name;
		this.description = description;
	}
	public AppRoleDto(ERole name, String description) {
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