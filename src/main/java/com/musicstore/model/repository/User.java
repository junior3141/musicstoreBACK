package com.musicstore.model.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username", length = 60, nullable = false)
	private String userName;
	
	@Column(name = "name", length = 60, nullable = false)
	private String name;
	
	@Column(name = "lastname", length = 60, nullable = false)
	private String lastName;
	
	@Column(name = "email", length = 60, nullable = false)
	private String email;
	
	@Column(name = "password", length = 60, nullable = false)
	private String password;
	
	@Column(name = "address", length = 60, nullable = false)
	private String address;	
	
	@Column(name = "is_admin", length = 1, nullable = false)
	private boolean admin;
	
	public User() {
		super();
	}

	public User(Integer id, String userName, String name, String lastName, String email, String password,
			String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}
