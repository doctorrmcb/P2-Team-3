package com.revature.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Component
@Entity
@Table(name = "lighthouse.users")
public class User {

	@Id
	@SequenceGenerator(name = "USERID_SEQ", sequenceName = "user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERID_SEQ")
	@Column(name = "user_id")
	private int userID;
	
	
	@Column(name = "username")
	private String username;

	@Column(name = "passwords")
	private String password;

	@Column(name = "fullName")
	private String fullName;

	@Column(name = "emailName")
	private String emailName;

	@Column(name = "roles")
	private String roles;

	@Column(name = "batch_id")
	private String batchID;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userID, String username, String password, String fullName, String emailName, String roles,
			String batchID) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.emailName = emailName;
		this.roles = roles;
		this.batchID = batchID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailName() {
		return emailName;
	}

	public void setEmailName(String emailName) {
		this.emailName = emailName;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchID == null) ? 0 : batchID.hashCode());
		result = prime * result + ((emailName == null) ? 0 : emailName.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + userID;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (batchID == null) {
			if (other.batchID != null)
				return false;
		} else if (!batchID.equals(other.batchID))
			return false;
		if (emailName == null) {
			if (other.emailName != null)
				return false;
		} else if (!emailName.equals(other.emailName))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (userID != other.userID)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + username + ", passWord=" + password + ", fullName=" + fullName
				+ ", emailName=" + emailName + ", roles=" + roles + ", batchID=" + batchID + "]";
	}

}