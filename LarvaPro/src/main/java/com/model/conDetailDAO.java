package com.model;

import java.util.ArrayList;
import java.util.List;

public class conDetailDAO extends DBconnection {

	// 공모전 상세내용, 삽입.
	public int insertConDetail(conDetailVO vo) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("insert into contest values(contest_number.nextval,?,?,?,?,?,?,?,?,?,?)");

			psmt.setString(1, vo.getConName());
			psmt.setString(2, vo.getConHost());
			psmt.setString(3, vo.getConField());
			psmt.setString(4, vo.getConQualfication());
			psmt.setString(5, vo.getConFromDate());
			psmt.setString(6, vo.getConToDate());
			psmt.setString(7, vo.getConHomePage());
			psmt.setString(8, vo.getConPostBig());
			psmt.setString(9, vo.getConPostSmall());
			psmt.setString(10, vo.getConContent());

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 공모전 상세내용. 수정
	public int updateConDetail(String conName, String conHost, String conField, String conQualfication,
			String conFromDate, String conTodate, String conHomePage, String conPostBig, String conPostSmall,
			String conContent) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement(
					"update contest set cnt_name=?, cnt_host=?, cnt_field=?, cnt_qualification=?, cnt_from_date=?, cnt_to_date=?, cnt_homepage=?, cnt_img_big=?, cnt_img_small=?,cnt_content=?");

			psmt.setString(1, conName);
			psmt.setString(2, conHost);
			psmt.setString(3, conField);
			psmt.setString(4, conQualfication);
			psmt.setString(5, conFromDate);
			psmt.setString(6, conTodate);
			psmt.setString(7, conHomePage);
			psmt.setString(8, conPostBig);
			psmt.setString(9, conPostSmall);
			psmt.setString(10, conContent);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 게시판 삭제
	public int deleteContest(String cntNum) {

		int cnt = 0;

		try {

			getConnection();

			psmt = conn.prepareStatement("delete from contest where cnt_num=?");

			psmt.setString(1, cntNum);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}

	// 게시글 표현 메소드
	public ArrayList<conDetailVO> showConDetail(conDetailVO vo) {

		ArrayList<conDetailVO> showConDetail_list = new ArrayList<conDetailVO>();

		try {

			getConnection();

			psmt = conn.prepareStatement("select cnt_name, cnt_from_date, cnt_to_date from contest");

			rs = psmt.executeQuery();

			while (rs.next()) {
				String conName = rs.getString("cnt_name");
				String conFromDate = rs.getString("cnt_from_date").substring(0, 10);
				String conToDate = rs.getString("cnt_to_date").substring(0, 10);

				conDetailVO vo2 = new conDetailVO(conName, conFromDate, conToDate);
				showConDetail_list.add(vo2);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return showConDetail_list;
	}

	// 특정 공모전 불러오기
	public conDetailVO selectCon(int num) {

		getConnection();
		conDetailVO contest = null;

		int cnt = 0;
		String name = null;
		String host = null;
		String filed = null;
		String qualfication = null;
		String fromDate = null;
		String toDate = null;
		String homepage = null;
		String imgSmall = null;
		String imgBig = null;
		String content = null;

		int cnt_num = num;

		try {
			psmt = conn.prepareStatement("select * from contest where cnt_num = ?");
			psmt.setInt(1, cnt_num);
			rs = psmt.executeQuery();

			if (rs.next()) {
				cnt = rs.getInt(1);
				name = rs.getString(2);
				host = rs.getString(3);
				filed = rs.getString(4);
				qualfication = rs.getString(5);

				fromDate = rs.getString(6).substring(0, 10);
				;
				toDate = rs.getString(7).substring(0, 10);
				;

				homepage = rs.getString(8);
				imgBig = rs.getString(9);
				imgSmall = rs.getString(10);
				content = rs.getString(11);
			}

		} catch (Exception e) {
		} finally {
			try {
				dbClose();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		contest = new conDetailVO(cnt, name, host, filed, qualfication, fromDate, toDate, homepage, imgSmall, imgBig,
				content);
		return contest;

	}

	// 리스트 페이지에 보여줄 로직(페이징 처리)
	public List<conDetailVO> getList() {
		// 페이징 처리를 위한 sql / 인라인뷰, rownum 사용
		String sql = "select * from contest";
		List<conDetailVO> list = null;
		try {
			getConnection(); // 커넥션을 얻어옴
			psmt = conn.prepareStatement(sql); // sql 정의
			rs = psmt.executeQuery(); // sql 실행
			if (rs.next()) { // 데이터베이스에 데이터가 있으면 실행
				list = new ArrayList<>(); // list 객체 생성
				do {
					// 반복할 때마다 ExboardDTO 객체를 생성 및 데이터 저장
					conDetailVO board = new conDetailVO();
					board.setConName(rs.getString("cnt_name"));
					board.setConFromDate(rs.getString("cnt_from_date").substring(0, 10));
					board.setConToDate(rs.getString("cnt_to_date").substring(0, 10));

					list.add(board); // list에 0번 인덱스부터 board 객체의 참조값을 저장
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(); // DB 연결 종료 / Connection 반환
		}
		return list; // list 반환
	}

	// 캘린더 구현시 필요한 메소드
	public ArrayList<conDetailVO> calList() {

		getConnection();
		ArrayList<conDetailVO> list = null;

		try {

			psmt = conn.prepareStatement("select * from contest where 80< cnt_num and  cnt_num < 100");
			rs = psmt.executeQuery();

			if (rs.next()) {
				list = new ArrayList<>();
				do {
					conDetailVO board = new conDetailVO();
					board.setConName(rs.getString("cnt_name"));
					board.setConFromDate(rs.getString("cnt_from_date").substring(0, 10));
					board.setConToDate(rs.getString("cnt_to_date").substring(0, 10));

					list.add(board);
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	// 해당 공모전 남은 날짜 계산 메소드
	public int oneContestD_Day(int cnt_num) {

		int date = 0;

		getConnection();

		try {
			psmt = conn.prepareStatement(
					"SELECT TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(CNT_TO_DATE) FROM contest where cnt_num=?");
			psmt.setInt(1, cnt_num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				date = rs.getInt(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return date;
	}

	// 이미지 가져오기
	public String bringSmallImg(int cnt_num) {

		getConnection();
		String img = null;

		try {
			psmt = conn.prepareStatement("SELECT cnt_img_small FROM contest where cnt_num=?");
			psmt.setInt(1, cnt_num);

			rs = psmt.executeQuery();

			while (rs.next()) {
				img = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return img;
	}
	
	//모든 공모전 남은 날짜 계산 메소드
	public ArrayList<DdayVO> D_Day(){
		
		getConnection();
		ArrayList<DdayVO> D_day=new ArrayList<DdayVO>();
		
		int Dday=0;
		int cnt=0;
		
		try {
			psmt=conn.prepareStatement("SELECT TO_DATE(TO_CHAR(SYSDATE, 'YYYYMMDD')) - TO_DATE(CNT_TO_DATE) FROM contest");
			rs=psmt.executeQuery();
			
			while(rs.next()) {
				 Dday=rs.getInt(1);
				 
				 DdayVO vo=new DdayVO(Dday,cnt);
				 D_day.add(vo);
				 cnt++;
				 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return D_day;
				
	}

}
