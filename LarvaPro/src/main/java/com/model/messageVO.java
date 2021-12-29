package com.model;

public class messageVO {
	
	private int mNum; //메시지 번호
	private String mSendId; //보낸 사람
	private String mReceiveId; //받은 사람
	private String mContent; // 내용
	private String mSendDate; //보낸 일자
	private String mReceiveDate; // 받은 일자
	private int mState; //읽음 : 0, 읽지 않음 : 1
	
	public messageVO(int mNum, String mSendId, String mReceiveId, String mContent, String mSendDate, String mReceiveDate, int mState) {
		super();
		this.mNum = mNum;
		this.mSendId = mSendId;
		this.mReceiveId = mReceiveId;
		this.mContent = mContent;
		this.mSendDate = mSendDate;
		this.mReceiveDate = mReceiveDate;
		this.mState = mState;
	}
	
	

	public messageVO(String mSendId, String mReceiveId, String mContent) {
		super();
		this.mSendId = mSendId;
		this.mReceiveId = mReceiveId;
		this.mContent = mContent;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

	public String getmSendId() {
		return mSendId;
	}

	public void setmSendId(String mSendId) {
		this.mSendId = mSendId;
	}

	public String getmReceiveId() {
		return mReceiveId;
	}

	public void setmReceiveId(String mReceiveId) {
		this.mReceiveId = mReceiveId;
	}

	public String getmContent() {
		return mContent;
	}

	public void setmContent(String mContent) {
		this.mContent = mContent;
	}

	public String getmSendDate() {
		return mSendDate;
	}

	public void setmSendDate(String mSendDate) {
		this.mSendDate = mSendDate;
	}

	public String getmReceiveDate() {
		return mReceiveDate;
	}

	public void setmReceiveDate(String mReceiveDate) {
		this.mReceiveDate = mReceiveDate;
	}

	public int getmState() {
		return mState;
	}

	public void setmState(int mState) {
		this.mState = mState;
	}
}
	
	
	

