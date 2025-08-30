package edu.cca.john.semester.models;

import java.util.Set;

public class AuthResponseDto {
	private int statusCode;
	private String error;
	private String message;
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userContact;
	private Set<AppRole> userRoles;
	
	
	public AuthResponseDto(int statusCode, String error, String message, String userName, String userEmail,
			String userPassword, String userContact, Set<edu.cca.john.semester.models.AppRole> userRoles) {
		super();
		this.statusCode = statusCode;
		this.error = error;
		this.message = message;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userContact = userContact;
		this.userRoles = userRoles;
	}
	public AuthResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public Set<AppRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<AppRole> userRoles) {
		this.userRoles = userRoles;
	}
	
	
	
	
}
