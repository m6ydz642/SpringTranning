package com.itwillbs.domain;

import com.sun.jmx.snmp.Timestamp;

public class MemberVO {
	// 회원정보를 저장하는 객체 (자바빈, DTO)
	private String userid;
	private String userpw;
	private String username;
	private String email;
	private Timestamp regTimestamp;
	private Timestamp updatedate;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
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
	public Timestamp getRegTimestamp() {
		return regTimestamp;
	}
	public void setRegTimestamp(Timestamp regTimestamp) {
		this.regTimestamp = regTimestamp;
	}
	public Timestamp getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", userpw=" + userpw + ", username=" + username + ", email=" + email
				+ ", regTimestamp=" + regTimestamp + ", updatedate=" + updatedate + ", toString()=" + super.toString()
				+ "]";
	}
	


	
	
	
	
	
}
