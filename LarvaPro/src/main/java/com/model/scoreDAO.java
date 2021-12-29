package com.model;

public class scoreDAO extends DBconnection {

	// com.controller와 연동
	public int insertScore(scoreVO vo) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("insert into score values(score_number.nextval,?,null,?,?)");

			psmt.setString(1, vo.getMemId());
			psmt.setString(2, vo.getScReceiveId());
			psmt.setInt(3, vo.getScReceive());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 평점조회 메소드
	public double showScore(String id) {

		getConnection();
		double avg = 0;
		try {

			psmt = conn.prepareStatement("select avg(sc_receive) from score where sc_receive_id=?");

			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				avg = Math.round(rs.getDouble(1)*100)/100.0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return avg;
	}
}