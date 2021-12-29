package com.model;

import java.util.ArrayList;

public class messageDAO extends DBconnection{
	
	//�޽��� �Է�
	public int insertMessage(messageVO vo) {
		
		int cnt = 0;
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("insert into message values(message_number.nextval,?,?,?,sysdate,sysdate,?)");
			
			psmt.setString(1, vo.getmSendId());
			psmt.setString(2, vo.getmReceiveId());
			psmt.setString(3, vo.getmContent());
			psmt.setInt(4, vo.getmState());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	//���� �޽��� ��ȸ
	public ArrayList<messageVO> showSendMessage(String SendId) {
		
		ArrayList<messageVO> message_list = new ArrayList<messageVO>();
		
		try {
			getConnection();
			
			psmt = conn.prepareStatement("select * from message where m_Send_id=?");
			
			psmt.setString(1, SendId);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				int mNum = rs.getInt("m_num");
				String mSendId = rs.getString("m_send_id");
				String mReceiveid = rs.getString("m_receive_id");
				String mContent = rs.getString("m_content");
				String mSendDate = rs.getString("m_send_date");
				String mReceiveDate = rs.getString("m_receive_date");
				int mState = rs.getInt("m_state");
				
				messageVO vo = new messageVO(mNum, mSendId, mReceiveid, mContent, mSendDate, mReceiveDate, mState);
				message_list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return message_list;
	}
	
	
	//���� �޽��� ��ȸ
	public ArrayList<messageVO> showReceiveMessage(String ReceiveId) {
		
		ArrayList<messageVO> message_list = new ArrayList<messageVO>();
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("select * from message where m_receive_id=?");
			
			psmt.setString(1, ReceiveId);
			
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				int mNum = rs.getInt("m_num");
				String mSendId = rs.getString("m_send_id");
				String mReceiveId = rs.getString("m_receive_id");
				String mContent = rs.getString("m_content");
				String mSendDate = rs.getString("m_send_date");
				String mReceiveDate = rs.getString("m_receive_date");
				int mState = rs.getInt("m_state");
				
				messageVO vo = new messageVO(mNum, mSendId, mReceiveId, mContent, mSendDate, mReceiveDate, mState);
				message_list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return message_list;
	}
	
	//�޽��� ��ü ����
	public int deleteMessage(String mReceiveId) {
		int cnt = 0;
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("delete from message where m_receive_id=?");
			
			psmt.setString(1, mReceiveId);
			
			cnt = psmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return cnt;
	}
	//�޽��� ���� ����
	public int deleteOne(String mNum) {
		
		int cnt = 0;
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("delete from message where m_num=?");
			
			psmt.setString(1, mNum);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	}
