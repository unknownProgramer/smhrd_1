package com.model;

public class scoreVO {

	private int scNum;
	private int cntNum;
	private String memId;
	private String scReceiveId;
	private int scReceive;
	
	public scoreVO(String memId, int scReceive,String scReceiveId) {
		super();
		this.memId = memId;
		this.scReceiveId = scReceiveId;
		this.scReceive = scReceive;
	}
	public int getScNum() {
		return scNum;
	}
	public void setScNum(int scNum) {
		this.scNum = scNum;
	}
	public int getCntNum() {
		return cntNum;
	}
	public void setCntNum(int cntNum) {
		this.cntNum = cntNum;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getScReceiveId() {
		return scReceiveId;
	}
	public void setScReceiveId(String scReceiveId) {
		this.scReceiveId = scReceiveId;
	}
	public int getScReceive() {
		return scReceive;
	}
	public void setScReceive(int scReceive) {
		this.scReceive = scReceive;
	}
	
}
