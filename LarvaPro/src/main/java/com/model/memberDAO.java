package com.model;

import java.util.ArrayList;

public class memberDAO extends DBconnection {

	// ȸ������ �޼ҵ�
	public int join(memberVO member) {

		getConnection();

		int cnt = 0;

		try {

			psmt = conn.prepareStatement("insert into member_info values(?,?,?,?,?,?,?,sysdate,1,'���� �λ��� �����ϴ�.')");
			psmt.setString(1, member.getMemId());
			psmt.setString(2, member.getMemPw());
			psmt.setString(3, member.getMemUserName());
			psmt.setString(4, member.getMemNickName());
			psmt.setString(5, member.getMemEmail());
			psmt.setString(6, member.getMemTel());
			psmt.setString(7, member.getMemAdress());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ȸ������ ����");
			e.printStackTrace();
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	// �α��� �޼ҵ�(member_info)
	public memberVO login(String id, String pw) {

		getConnection();
		memberVO memberInfo = null;

		String memId = null;
		String memPw = null;
		String memUserName = null;
		String memNickName = null;
		String memEmail = null;
		String memTel = null;
		String memAddress = null;
		String memDate = null;
		int memLevel = 0;
		String memHi = null;

		try {

			psmt = conn.prepareStatement("select * from member_info where mem_id = ? and mem_pw = ?");
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();

			if (rs.next()) {
				memId = rs.getString(1);
				memPw = rs.getString(2);
				memUserName = rs.getString(3);
				memNickName = rs.getString(4);
				memEmail = rs.getString(5);
				memTel = rs.getString(6);
				memAddress = rs.getString(7);
				memDate = rs.getString(8).substring(0,10);
				memLevel = rs.getInt(9);
				memHi = rs.getString(10);

				memberInfo = new memberVO(memId, memPw, memUserName, memNickName, memEmail, memTel, memAddress, memDate,
						memLevel, memHi);
			}
		} catch (Exception e) {
			return memberInfo;
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberInfo;
	}

	// ������ �޼ҵ� (�ش� ���̵�,����� ����)
	public void levelUp(String id, int levelUp) {

		int nowLevel = 0;
		int result = 0;

		try {
			getConnection();

			psmt = conn.prepareStatement("select*from member_info where mem_id=?");

			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				nowLevel = rs.getInt(9);
			}

			nowLevel += levelUp;

			psmt = conn.prepareStatement("update member_info set mem_level=? where mem_id=?");

			psmt.setInt(1, nowLevel);
			psmt.setString(2, id);

			result = psmt.executeUpdate();

			if (result > 0) {
				System.out.println("������~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// ȸ������ ���� �޼ҵ�
	public int updateMemberInfo(String pw,String name, String nickName, String email, String tel, String add, String hi, String id) {

		getConnection();
		int result=0;

		try {

			psmt = conn.prepareStatement(
					"update member_info set mem_pw=? , mem_username=? , mem_nickname=? , mem_email=? , mem_tel=?,  mem_address=? , mem_hi=? where mem_id=?");
			
			psmt.setString(1, pw);
			psmt.setString(2, name);
			psmt.setString(3, nickName);
			psmt.setString(4, email);
			psmt.setString(5, tel);
			psmt.setString(6, add);
			psmt.setString(7, hi);
			psmt.setString(8, id);
			
			result = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("��������");
			e.printStackTrace();
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	//�ش� ������ ������� ȣ�� �޼ҵ�
	public memberVO getMemberInfo(int level) {
		getConnection();
		memberVO memberInfomation = null;
		
		String memId = null;
		String memPw = null;
		String memUserName = null;
		String memNickName = null;
		String memEmail = null;
		String memTel = null;
		String memAddress = null;
		String memDate = null;
		int memLevel = 0;
		String memHi = null;

		try {
				
			psmt = conn.prepareStatement("select * from member_info where mem_level = ?");
			psmt.setInt(1, level);

			rs = psmt.executeQuery();

			if (rs.next()) {
				memId = rs.getString(1);
				memPw = rs.getString(2);
				memUserName = rs.getString(3);
				memNickName = rs.getString(4);
				memEmail = rs.getString(5);
				memTel = rs.getString(6);
				memAddress = rs.getString(7);
				memDate = rs.getString(8).substring(0,10);
				memLevel = rs.getInt(9);
				memHi = rs.getString(10);

				memberInfomation = new memberVO(memId, memPw, memUserName, memNickName, memEmail, memTel, memAddress, memDate,
						memLevel, memHi);
			}
		} catch (Exception e) {
			return memberInfomation;
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberInfomation;
	}
	
	//������ ���� ����� ArrayList�� �����ϴ� �޼ҵ�
	public ArrayList<Integer> topLevel() {
		getConnection();
	
		ArrayList<Integer> memLevels=new ArrayList<Integer>();
		int memLevel = 0;
		
		try {
				
			psmt = conn.prepareStatement("select * from member_info order by mem_level DESC");

			rs = psmt.executeQuery();
			
			while (rs.next()) {
				memLevel = rs.getInt("mem_level");
				memLevels.add(memLevel);
			}
		} catch (Exception e) {
			return memLevels;
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memLevels;
	}
	
	//��� ȸ������ �ҷ����� �޼ҵ�
	public ArrayList<memberVO> allMember() {

		getConnection();
		memberVO memberInfo = null;
		ArrayList<memberVO> memberInfoList=new ArrayList<memberVO>();
		
		String memId = null;
		String memPw = null;
		String memUserName = null;
		String memNickName = null;
		String memEmail = null;
		String memTel = null;
		String memAddress = null;
		String memDate = null;
		int memLevel = 0;
		String memHi = "";

		try {

			psmt = conn.prepareStatement("select * from member_info");

			rs = psmt.executeQuery();

			while (rs.next()) {
				memId = rs.getString(1);
				memPw = rs.getString(2);
				memUserName = rs.getString(3);
				memNickName = rs.getString(4);
				memEmail = rs.getString(5);
				memTel = rs.getString(6);
				memAddress = rs.getString(7);
				memDate = rs.getString(8).substring(0,10);
				memLevel = rs.getInt(9);
				memHi = rs.getString(10);

				memberInfo = new memberVO(memId, memPw, memUserName, memNickName, memEmail, memTel, memAddress, memDate,
						memLevel, memHi);
				
				memberInfoList.add(memberInfo);
			}
		} catch (Exception e) {
			return memberInfoList;
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return memberInfoList;
	}
	
	// �α��� �޼ҵ�(id)
		public memberVO loginId(String id) {

			getConnection();
			memberVO memberInfo = null;

			String memId = null;
			String memPw = null;
			String memUserName = null;
			String memNickName = null;
			String memEmail = null;
			String memTel = null;
			String memAddress = null;
			String memDate = null;
			int memLevel = 0;
			String memHi = null;

			try {

				psmt = conn.prepareStatement("select * from member_info where mem_id = ?");
				psmt.setString(1, id);

				rs = psmt.executeQuery();

				if (rs.next()) {
					memId = rs.getString(1);
					memPw = rs.getString(2);
					memUserName = rs.getString(3);
					memNickName = rs.getString(4);
					memEmail = rs.getString(5);
					memTel = rs.getString(6);
					memAddress = rs.getString(7);
					memDate = rs.getString(8).substring(0,10);
					memLevel = rs.getInt(9);
					memHi = rs.getString(10);

					memberInfo = new memberVO(memId, memPw, memUserName, memNickName, memEmail, memTel, memAddress, memDate,
							memLevel, memHi);
				}
			} catch (Exception e) {
				return memberInfo;
			} finally {
				try {
					dbClose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return memberInfo;
		}

}
