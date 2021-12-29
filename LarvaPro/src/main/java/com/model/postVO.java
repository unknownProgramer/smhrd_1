package com.model;

public class postVO {
	
	private int rpNum; //모집 게시판 번호
	private String memId; //회원아이디
	private int cntNum; //공모전 번호 pk
	private String rpTitle; //제목
	private int rpMemNum; //모집인원
	private int rpField; //모집분야 1,2,3,4
	private String rpContent; //내용
	private String rpDate; //등록일자
	private int rpProgress; //모집중,마감
	
	
	

	
	public postVO(int rpNum, String memId, int cntNum, String rpTitle, int rpMemNum, int rpField, String rpContent,
		String rpDate, int rpProgress) {
	super();
	this.rpNum = rpNum;
	this.memId = memId;
	this.cntNum = cntNum;
	this.rpTitle = rpTitle;
	this.rpMemNum = rpMemNum;
	this.rpField = rpField;
	this.rpContent = rpContent;
	this.rpDate = rpDate;
	this.rpProgress = rpProgress;
}



	public int getRpNum() {
		return rpNum;
	}
	public void setRpNum(int rpNum) {
		this.rpNum = rpNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getCntNum() {
		return cntNum;
	}
	public void setCntNum(int cntNum) {
		this.cntNum = cntNum;
	}
	public String getRpTitle() {
		return rpTitle;
	}
	public void setRpTitle(String rpTitle) {
		this.rpTitle = rpTitle;
	}
	public int getRpMemNum() {
		return rpMemNum;
	}
	public void setRpMemNum(int rpMemNum) {
		this.rpMemNum = rpMemNum;
	}
	public int getRpField() {
		return rpField;
	}
	public void setRpField(int rpField) {
		this.rpField = rpField;
	}
	public String getRpContent() {
		return rpContent;
	}
	public void setRpContent(String rpContent) {
		this.rpContent = rpContent;
	}
	public String getRpDate() {
		return rpDate;
	}
	public void setRpDate(String rpDate) {
		this.rpDate = rpDate;
	}
	public int getRpProgress() {
		return rpProgress;
	}
	public void setRpProgress(int rpProgress) {
		this.rpProgress = rpProgress;
	}

	

}
