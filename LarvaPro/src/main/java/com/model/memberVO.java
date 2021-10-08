package com.model;

public class memberVO {
	private String memId;
	private String memPw;
	private String memUserName;
	private String memNickName;
	private String memEmail;
	private String memTel;
	private String memAdress;
	private String memSignUpDate;
	
	public memberVO(String memId, String memPw, String memUserName, String memNickName, String memEmail, String memTel,
			String memAdress, String memSignUpDate) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memUserName = memUserName;
		this.memNickName = memNickName;
		this.memEmail = memEmail;
		this.memTel = memTel;
		this.memAdress = memAdress;
		this.memSignUpDate = memSignUpDate;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemUserName() {
		return memUserName;
	}

	public void setMemUserName(String memUserName) {
		this.memUserName = memUserName;
	}

	public String getMemNickName() {
		return memNickName;
	}

	public void setMemNickName(String memNickName) {
		this.memNickName = memNickName;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemAdress() {
		return memAdress;
	}

	public void setMemAdress(String memAdress) {
		this.memAdress = memAdress;
	}

	public String getMemSignUpDate() {
		return memSignUpDate;
	}

	public void setMemSignUpDate(String memSignUpDate) {
		this.memSignUpDate = memSignUpDate;
	}
	
	
	
	
	

}
