package com.model;

import java.util.ArrayList;

public class memberDAO extends DBconnection {

	// 회원가입 메소드
	public int join(memberVO member) {

		getConnection();

		int cnt = 0;

		try {

			psmt = conn.prepareStatement("insert into member_info values(?,?,?,?,?,?,?,sysdate,1,'아직 인삿말이 없습니다.')");
			psmt.setString(1, member.getMemId());
			psmt.setString(2, member.getMemPw());
			psmt.setString(3, member.getMemUserName());
			psmt.setString(4, member.getMemNickName());
			psmt.setString(5, member.getMemEmail());
			psmt.setString(6, member.getMemTel());
			psmt.setString(7, member.getMemAdress());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원가입 실패");
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

	// 로그인 메소드(member_info)
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

	// 레벨업 메소드 (해당 아이디,상승할 레벨)
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
				System.out.println("레벨업~");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// 회원정보 수정 메소드
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
			System.out.println("수정실패");
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
	
	//해당 레벨의 멤버정보 호출 메소드
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
	
	//레벨이 높은 순대로 ArrayList에 삽입하는 메소드
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
	
	//모든 회원정보 불러오는 메소드
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
	
	// 로그인 메소드(id)
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
