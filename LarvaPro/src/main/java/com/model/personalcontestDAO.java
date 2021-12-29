package com.model;

import java.util.ArrayList;

public class personalcontestDAO extends DBconnection {

	// 개인 공모전 내역 입력
	public int insertPersonalConetest(personalcontestVO vo) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn
					.prepareStatement("insert into personal_contest values(personal_contest_number.nextval,?,?,?,?,?)");

			psmt.setString(1, vo.getMemId());
			psmt.setInt(2, vo.getCntNum());
			psmt.setString(3, vo.getPcntPosition());
			psmt.setString(4, vo.getPcntContent());
			psmt.setInt(5, vo.getPcntType());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 개인 공모전 내역 조회
	public ArrayList<personalcontestVO> showPersonalContest(String id) {

		ArrayList<personalcontestVO> personalContestList = new ArrayList<personalcontestVO>();

		try {

			getConnection();

			psmt = conn.prepareStatement("select * from personal_contest where mem_id=?");

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {
				int pcntNum = rs.getInt("pcnt_num");
				String memId = rs.getString("mem_id");
				int cntNum = Integer.parseInt(rs.getString("cnt_num"));
				String pcntPosition = rs.getString("pcnt_position");
				String pcntContest = rs.getString("pcnt_content");
				int pcntType = Integer.parseInt(rs.getString("pcnt_type"));

				personalcontestVO vo = new personalcontestVO(pcntNum, memId, cntNum, pcntPosition, pcntContest,
						pcntType);
				personalContestList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return personalContestList;
	}

	// 개인 공모전 내역 수정
	public int updatePersonalContest(String cntNum, String position, String content, String type, String pcNum) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement(
					"update personal_contest set cnt_num=?, pcnt_position=?, pcnt_content=?, pcnt_type=? where pcnt_num=?)");

			psmt.setString(1, cntNum);
			psmt.setString(2, position);
			psmt.setString(3, content);
			psmt.setString(4, type);
			psmt.setString(5, pcNum);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 개인 공모전 내역 선택 삭제
	public int deleteOnePersonalConetest(String pcntNum) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("delete from personal_contest where pcnt_num=?");

			psmt.setString(1, pcntNum);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 개인 공모전 내역 선택 삭제
	public int deleteAllPersonalConetest(String memId) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("delete from personal_contest where mem_id=?");

			psmt.setString(1, memId);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 개인 공모전 내역 중 개인일기,지원분야 수정(매개변수 : 개인 공모전 번호,지원분야,일기)
	public int updateDairy(String pcntNum, String position, String content) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn
					.prepareStatement("update personal_contest set pcnt_content=? , pcnt_position=? where pcnt_num=?");

			psmt.setString(1, content);
			psmt.setString(2, position);
			psmt.setString(3, pcntNum);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

}
