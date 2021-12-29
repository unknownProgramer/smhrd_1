package com.model;

public class conDetailVO {

	private int conNum; // 공모전 번호
	private String conName;// 공모전 이름
	private String conHost;// 주체,주관
	private String conField; // 응모분야
	private String conQualfication; // 참가자격
	private String conFromDate; // 시작날짜
	private String conToDate; // 끝 날짜
	private String conHomePage; // 홈페이지>>공모전 주체하는 홈페이지
	private String conPostBig; // 큰 포스터
	private String conPostSmall; // 작은 포스터
	private String conContent; // 공모전 상세

	public conDetailVO() {
		super();
	}

	public conDetailVO(String conPostSmall) {
		super();
		this.conPostSmall = conPostSmall;
	}

	public conDetailVO(String conName, String conFromDate, String conToDate) {
		super();
		this.conName = conName;
		this.conFromDate = conFromDate;
		this.conToDate = conToDate;
	}

	public conDetailVO(int conNum, String conName, String conHost, String conField, String conQualfication,
			String conFromDate, String conToDate, String conHomePage, String conPostBig, String conPostSmall,
			String conContent) {
		super();
		this.conNum = conNum;
		this.conName = conName;
		this.conHost = conHost;
		this.conField = conField;
		this.conQualfication = conQualfication;
		this.conFromDate = conFromDate;
		this.conToDate = conToDate;
		this.conHomePage = conHomePage;
		this.conPostBig = conPostBig;
		this.conPostSmall = conPostSmall;
		this.conContent = conContent;
	}

	public int getConNum() {
		return conNum;
	}

	public void setConNum(int conNum) {
		this.conNum = conNum;
	}

	public String getConName() {
		return conName;
	}

	public void setConName(String conName) {
		this.conName = conName;
	}

	public String getConHost() {
		return conHost;
	}

	public void setConHost(String conHost) {
		this.conHost = conHost;
	}

	public String getConField() {
		return conField;
	}

	public void setConField(String conField) {
		this.conField = conField;
	}

	public String getConQualfication() {
		return conQualfication;
	}

	public void setConQualfication(String conQualfication) {
		this.conQualfication = conQualfication;
	}

	public String getConFromDate() {
		return conFromDate;
	}

	public void setConFromDate(String conFromDate) {
		this.conFromDate = conFromDate;
	}

	public String getConToDate() {
		return conToDate;
	}

	public void setConToDate(String conToDate) {
		this.conToDate = conToDate;
	}

	public String getConHomePage() {
		return conHomePage;
	}

	public void setConHomePage(String conHomePage) {
		this.conHomePage = conHomePage;
	}

	public String getConPostBig() {
		return conPostBig;
	}

	public void setConPostBig(String conPostBig) {
		this.conPostBig = conPostBig;
	}

	public String getConPostSmall() {
		return conPostSmall;
	}

	public void setConPostSmall(String conPostSmall) {
		this.conPostSmall = conPostSmall;
	}

	public String getConContent() {
		return conContent;
	}

	public void setConContent(String conContent) {
		this.conContent = conContent;
	}

}
