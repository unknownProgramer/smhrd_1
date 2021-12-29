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
	private int memLevel;
	private String memHi;
	
	public memberVO() {
		
	}
	
	public memberVO(String memId, String memPw, String memUserName, String memNickName, String memEmail, String memTel,
			String memAdress, String memSignUpDate, int memLevel, String memHi) {
		super();
		this.memId = memId;
		this.memPw = memPw;
		this.memUserName = memUserName;
		this.memNickName = memNickName;
		this.memEmail = memEmail;
		this.memTel = memTel;
		this.memAdress = memAdress;
		this.memSignUpDate = memSignUpDate;
		this.memLevel = memLevel;
		this.memHi = memHi;
	}

	public String getMemId() {
		return memId;
	}

	public String getMemHi() {
		return memHi;
	}

	public void setMemHi(String memHi) {
		this.memHi = memHi;
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

	public int getMemLevel() {
		return memLevel;
	}

	public void setMemLevel(int memLevel) {
		this.memLevel = memLevel;
	}

	public void setMemSignUpDate(String memSignUpDate) {
		this.memSignUpDate = memSignUpDate;
	}
	
	
	
	
	

}
