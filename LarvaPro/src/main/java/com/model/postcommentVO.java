package com.model;

public class postcommentVO {
	
	private int pcNum; //댓글 번호
	private int pcRpNum; //모집 게시판 번호
	private int pcCntNum; //공모전 번호
	private String pcMemId; //작성자 아이디
	private String pcContent; //내용
	private String pcDate; //작성일자
	
	
	
	public postcommentVO() {
		super();
	}

	public postcommentVO(String pcContent) {
		super();
		this.pcContent = pcContent;
	}

	public postcommentVO(String pcMemId, String pcContent, String pcDate) {
		super();
		this.pcMemId = pcMemId;
		this.pcContent = pcContent;
		this.pcDate = pcDate;
	}
	
	public int getPcNum() {
		return pcNum;
	}
	public void setPcNum(int pcNum) {
		this.pcNum = pcNum;
	}
	public int getPcRpNum() {
		return pcRpNum;
	}
	public void setPcRpNum(int pcRpNum) {
		this.pcRpNum = pcRpNum;
	}
	public int getPcCntNum() {
		return pcCntNum;
	}
	public void setPcCntNum(int pcCntNum) {
		this.pcCntNum = pcCntNum;
	}
	public String getPcMemId() {
		return pcMemId;
	}
	public void setPcMemId(String pcMemId) {
		this.pcMemId = pcMemId;
	}
	public String getPcContent() {
		return pcContent;
	}
	public void setPcContent(String pcContent) {
		this.pcContent = pcContent;
	}
	public String getPcDate() {
		return pcDate;
	}
	public void setPcDate(String pcDate) {
		this.pcDate = pcDate;
	}
	
	
	
}