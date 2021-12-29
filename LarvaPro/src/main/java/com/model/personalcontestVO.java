package com.model;

public class personalcontestVO {

	private int pcntNum;
	private String memId;
	private int cntNum;
	private String pcntPosition;
	private String pcntContent;
	private int pcntType;
	
	public personalcontestVO(int pcntNum, String memId, int cntNum, String pcntPosition, String pcntContent,
			int pcntType) {
		super();
		this.pcntNum = pcntNum;
		this.memId = memId;
		this.cntNum = cntNum;
		this.pcntPosition = pcntPosition;
		this.pcntContent = pcntContent;
		this.pcntType = pcntType;
	}

	public personalcontestVO(String memId, int cntNum, String pcntPosition, String pcntContent, int pcntType) {
		super();
		this.memId = memId;
		this.cntNum = cntNum;
		this.pcntPosition = pcntPosition;
		this.pcntContent = pcntContent;
		this.pcntType = pcntType;
	}
	
	public int getPcntNum() {
		return pcntNum;
	}
	public void setPcntNum(int pcntNum) {
		this.pcntNum = pcntNum;
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
	public String getPcntPosition() {
		return pcntPosition;
	}
	public void setPcntPosition(String pcntPosition) {
		this.pcntPosition = pcntPosition;
	}
	public String getPcntContent() {
		return pcntContent;
	}
	public void setPcntContent(String pcntContent) {
		this.pcntContent = pcntContent;
	}
	public int getPcntType() {
		return pcntType;
	}
	public void setPcntType(int pcntType) {
		this.pcntType = pcntType;
	}
	
	
}
