package com.model;

public class postVO {
	
	private int rpNum; //���� �Խ��� ��ȣ
	private String memId; //ȸ�����̵�
	private int cntNum; //������ ��ȣ pk
	private String rpTitle; //����
	private int rpMemNum; //�����ο�
	private int rpField; //�����о� 1,2,3,4
	private String rpContent; //����
	private String rpDate; //�������
	private int rpProgress; //������,����
	
	
	

	
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
