package com.vote.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String username;
	
	private String email;
	
	private String mobile;
	
	private String password;
	private String role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Candidates candidates;

	public User() {

	}

	public User(int id, String username, String email, String mobile, String password, String role,
			Candidates candidates) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.candidates = candidates;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Candidates getCandidates() {
		return candidates;
	}

	public void setCandidates(Candidates candidates) {
		this.candidates = candidates;
	}

}
