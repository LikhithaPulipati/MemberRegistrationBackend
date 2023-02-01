package com.legato.MemberRegistrationPortal.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;

@Getter
@Setter
@Entity
public class Claim {
	@Id
	@GeneratedValue
	private int claimId;
	private int userId;
	private long claimToken;
	private LocalDate claimDate;
	private String email;
	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getClaimToken() {
		return claimToken;
	}
	public void setClaimToken(long claimToken) {
		this.claimToken = claimToken;
	}
	public LocalDate getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
