package com.model;

import java.util.ArrayList;

public class teamDAO extends DBconnection {

	// �� ���� (���� ����)
	public int createTeam(teamVO vo) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("insert into team_member values(?,?,?,?,?,?,?,?)");

			psmt.setString(1, vo.getMemId());
			psmt.setInt(2, vo.getCntNum());
			psmt.setInt(3, vo.getTmNum());
			psmt.setInt(4, vo.getTmType());
			psmt.setString(5, vo.getPosition());
			psmt.setInt(6, vo.getTmFull());
			psmt.setString(7, vo.getTitle());
			psmt.setString(8, vo.getContent());

			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	// �� ���� (��Ƽ�� ����)
		public int createTeamLeader(teamVO vo) {
			
			int cnt = 0;

			try {

				getConnection();

				psmt = conn.prepareStatement("insert into team_member values(?,?,?,?,?,?,?,?)");

				psmt.setString(1, vo.getMemId());
				psmt.setInt(2, vo.getCntNum());
				psmt.setInt(3, vo.getTmNum());
				psmt.setInt(4, vo.getTmType());
				psmt.setString(5, vo.getPosition());
				psmt.setInt(6, vo.getTmFull());
				psmt.setString(7, vo.getTitle());
				psmt.setString(8, vo.getContent());
				
				cnt = psmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return cnt;
		}

	// ��� �� ���� ��ȸ(�������������� ������ ��)
	public ArrayList<teamVO> showAllTeam() {

		ArrayList<teamVO> teamMemNum_list = new ArrayList<teamVO>();

		try {
			getConnection();

			psmt = conn.prepareStatement("select * from team_member");
			rs = psmt.executeQuery();

			while (rs.next()) {
				String mem_id = rs.getString("mem_id");
				int cnt_num = rs.getInt("cnt_num");
				int tm_num = rs.getInt("tm_num");
				int tm_type = rs.getInt("tm_type");
				String position = rs.getString("position");
				int tm_full = rs.getInt("tm_full");
				String title = rs.getString("title");
				String content = rs.getString("content");

				teamVO vo = new teamVO(mem_id, cnt_num, tm_num, tm_type, position, tm_full, title, content);
				teamMemNum_list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemNum_list;
	}

	// ���� �̸� ��ȸ
	public ArrayList<teamVO> showTeamMemberId(String tm_num) {

		ArrayList<teamVO> teamMemNum_list = new ArrayList<teamVO>();

		try {
			getConnection();

			psmt = conn.prepareStatement("select distinct mem_id from team_member where tm_num=?");

			psmt.setString(1, tm_num);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String ghMemId = rs.getString("mem_id");

				teamVO vo = new teamVO(ghMemId);
				teamMemNum_list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemNum_list;
	}

	// �ش� ����ȣ�� ���� �� ��ȸ
	public int showTeamMemberNum(int tm_num) {

		int teamMemberCnt = 0;

		try {
			getConnection();

			psmt = conn.prepareStatement("select count(mem_id) AS CNT from team_member where tm_num=?");

			psmt.setInt(1, tm_num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				teamMemberCnt = rs.getInt("cnt");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemberCnt;
	}

	// �� ���� ȣ�� (ȸ�� ���̵� �Ű������� �޾� �ش��ϴ� ���̵��� ��� �� ���� ȣ��)
	public ArrayList<teamVO> selectMyTeam(String memId) {

		ArrayList<teamVO> teamMemId_list = new ArrayList<teamVO>();

		try {
			getConnection();

			psmt = conn.prepareStatement("select * from team_member where mem_id=?");

			psmt.setString(1, memId);

			rs = psmt.executeQuery();

			while (rs.next()) {

				String mem_Id = rs.getString("mem_id");
				int cnt_Num = rs.getInt("cnt_num");
				int tm_Num = rs.getInt("tm_num");
				int tm_Type = rs.getInt("tm_type");
				String position = rs.getString("position");
				int tm_full = rs.getInt("tm_full");
				String title = rs.getString("title");
				String content = rs.getString("content");

				teamVO vo = new teamVO(mem_Id, cnt_Num, tm_Num, tm_Type, position, tm_full, title, content);
				teamMemId_list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemId_list;
	}

	// ���� ��� �� ���� �˾ƺ���
	public int maxTeam() {

		int maxTeam = 0;
		getConnection();

		try {
			psmt = conn.prepareStatement("select * from team_member order by tm_num DESC");
			rs = psmt.executeQuery();

			if (rs.next()) {
				maxTeam = rs.getInt("tm_num");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return maxTeam;
	}

	// �������� �׷��� ���� ���� �ִ� �������� ��ȸ
	public ArrayList<teamVO> showTeamMember(int cnt_num, int tm_num) {

		ArrayList<teamVO> teamMemNum_list = new ArrayList<teamVO>();

		try {
			getConnection();

			psmt = conn.prepareStatement("select * from team_member where cnt_num=? and tm_num=? order by tm_type");

			psmt.setInt(1, cnt_num);
			psmt.setInt(2, tm_num);

			rs = psmt.executeQuery();

			while (rs.next()) {
				String mem_id = rs.getString("mem_id");
				int cnt_num2 = rs.getInt("cnt_num");
				int tm_num2 = rs.getInt("tm_num");
				int tm_type = rs.getInt("tm_type");
				String position = rs.getString("position");
				int tm_full = rs.getInt("tm_full");
				String title = rs.getString("title");
				String content = rs.getString("content");

				teamVO vo = new teamVO(mem_id, cnt_num2, tm_num2, tm_type, position, tm_full, title, content);
				teamMemNum_list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemNum_list;
	}

	// �׷� ��ȣ ��ȸ
	public ArrayList<teamVO> searchTeamNum(String memId) {

		ArrayList<teamVO> teamMemId_list = new ArrayList<teamVO>();

		try {
			getConnection();

			psmt = conn.prepareStatement("select tm_num from team_member where mem_id=?");

			psmt.setString(1, memId);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int tmNum = rs.getInt("tm_num");

				teamVO vo = new teamVO(tmNum);
				teamMemId_list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return teamMemId_list;
	}
	
	//��Ƽ���� ������ ��ȸ
	public teamVO selectOneTeam(int tm_num) {
		
		teamVO vo=null;
		
		try {
			getConnection();

			psmt = conn.prepareStatement("select * from team_member where tm_num=? and tm_type=0");

			psmt.setInt(1, tm_num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String mem_id = rs.getString("mem_id");
				int cnt_num2 = rs.getInt("cnt_num");
				int tm_num2 = rs.getInt("tm_num");
				int tm_type = rs.getInt("tm_type");
				String position = rs.getString("position");
				int tm_full = rs.getInt("tm_full");
				String title = rs.getString("title");
				String content = rs.getString("content");

				vo = new teamVO(mem_id, cnt_num2, tm_num2, tm_type, position, tm_full, title, content);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}
	
	//��Ƽ ��ü
	
public int deleteTeam(int tm_num) {
	
	getConnection();
	int cnt=0;
	try {
		
		psmt = conn.prepareStatement("DELETE FROM team_member WHERE tm_num = ?");

		psmt.setInt(1, tm_num);

		cnt = psmt.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		dbClose();
	}return cnt;
}
}
