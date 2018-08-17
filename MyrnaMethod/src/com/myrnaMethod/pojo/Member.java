package com.myrnaMethod.pojo;

import java.util.Date;

public class Member {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String memberId;
	private Date validUntil;
	private int active;
	private Date startDate;
	private int memberFor;
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(Date validUntil) {
		this.validUntil = validUntil;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public int getMemberFor() {
		return memberFor;
	}
	public void setMemberFor(int memberFor) {
		this.memberFor = memberFor;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", memberId=" + memberId + ", validUntil=" + validUntil + ", active=" + active
				+ ", startDate=" + startDate + ", memberFor=" + memberFor + "]";
	}	

}
