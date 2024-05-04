package com.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Candidates {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int canId;
	private int candidate1;
	private int candidate2;
	private int candidate3;
	private int candidate4;

	@OneToOne
	private User user;

	public Candidates() {

	}

	public Candidates(int canId, int candidate1, int candidate2, int candidate3, int candidate4, User user) {
		super();
		this.canId = canId;
		this.candidate1 = candidate1;
		this.candidate2 = candidate2;
		this.candidate3 = candidate3;
		this.candidate4 = candidate4;
		this.user = user;
	}

	public int getCanId() {
		return canId;
	}

	public void setCanId(int canId) {
		this.canId = canId;
	}

	public int getCandidate1() {
		return candidate1;
	}

	public void setCandidate1(int candidate1) {
		this.candidate1 = candidate1;
	}

	public int getCandidate2() {
		return candidate2;
	}

	public void setCandidate2(int candidate2) {
		this.candidate2 = candidate2;
	}

	public int getCandidate3() {
		return candidate3;
	}

	public void setCandidate3(int candidate3) {
		this.candidate3 = candidate3;
	}

	public int getCandidate4() {
		return candidate4;
	}

	public void setCandidate4(int candidate4) {
		this.candidate4 = candidate4;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
