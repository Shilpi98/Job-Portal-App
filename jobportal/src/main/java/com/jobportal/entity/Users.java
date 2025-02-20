package com.jobportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.*;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique=true)
	private String email;
	
	@NotEmpty
	private String password;
	
	private boolean isActive;
	
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date registrationDate;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userTypeId", referencedColumnName="userTypeId")
	private UsersType userTypeId;
	
	public Users() {
		
	}

	public Users(int userId, String email, @NotEmpty String password, boolean isActive, Date registrartionDate,
			UsersType userTypeId) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
		this.registrationDate = registrartionDate;
		this.userTypeId = userTypeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getRegistrartionDate() {
		return registrationDate;
	}

	public void setRegistrartionDate(Date registrartionDate) {
		this.registrationDate = registrartionDate;
	}

	public UsersType getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(UsersType userTypeId) {
		this.userTypeId = userTypeId;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", password=" + password + ", isActive=" + isActive
				+ ", registrartionDate=" + registrationDate + ", userTypeId=" + userTypeId + "]";
	}
	
	
}
