package com.model;

public class teamVO {

	private String MemId;
	private int cntNum;
	private int tmNum;
	private int tmType;
	private String position;
	private int tmFull;
	private String title;
	private String content;

	public teamVO(String memId, int cntNum, int tmNum, int tmType, String position, int tmFull, String title,
			String content) {
		super();
		MemId = memId;
		this.cntNum = cntNum;
		this.tmNum = tmNum;
		this.tmType = tmType;
		this.position = position;
		this.tmFull = tmFull;
		this.title = title;
		this.content = content;
	}

	public teamVO(String memId, int cntNum, int tmNum, int tmType, String position, int tmFull) {
		super();
		MemId = memId;
		this.cntNum = cntNum;
		this.tmNum = tmNum;
		this.tmType = tmType;
		this.position = position;
		this.tmFull = tmFull;
	}

	public teamVO(String memId, int tmNum) {
		super();
		MemId = memId;
		this.tmNum = tmNum;
	}
	
	public teamVO(String memId) {
		super();
		MemId = memId;
	}

	public teamVO(int tmNum) {
		super();
		this.tmNum = tmNum;
	}


	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getTmFull() {
		return tmFull;
	}

	public void setTmFull(int tmFull) {
		this.tmFull = tmFull;
	}

	public String getMemId() {
		return MemId;
	}

	public void setMemId(String memId) {
		MemId = memId;
	}

	public int getCntNum() {
		return cntNum;
	}

	public void setCntNum(int cntNum) {
		this.cntNum = cntNum;
	}

	public int getTmNum() {
		return tmNum;
	}

	public void setTmNum(int tmNum) {
		this.tmNum = tmNum;
	}

	public int getTmType() {
		return tmType;
	}

	public void setTmType(int tmType) {
		this.tmType = tmType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}