package com.model;

public class postcommentVO {
	
	private int pcNum; //��� ��ȣ
	private int pcRpNum; //���� �Խ��� ��ȣ
	private int pcCntNum; //������ ��ȣ
	private String pcMemId; //�ۼ��� ���̵�
	private String pcContent; //����
	private String pcDate; //�ۼ�����
	
	
	
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