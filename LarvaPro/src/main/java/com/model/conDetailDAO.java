package com.model;

import java.util.ArrayList;
import java.util.List;

public class conDetailDAO extends DBconnection {

	// ������ �󼼳���, ����.
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

	// ������ �󼼳���. ����
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

	// �Խ��� ����
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

	// �Խñ� ǥ�� �޼ҵ�
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

	// Ư�� ������ �ҷ�����
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

	// ����Ʈ �������� ������ ����(����¡ ó��)
	public List<conDetailVO> getList() {
		// ����¡ ó���� ���� sql / �ζ��κ�, rownum ���
		String sql = "select * from contest";
		List<conDetailVO> list = null;
		try {
			getConnection(); // Ŀ�ؼ��� ����
			psmt = conn.prepareStatement(sql); // sql ����
			rs = psmt.executeQuery(); // sql ����
			if (rs.next()) { // �����ͺ��̽��� �����Ͱ� ������ ����
				list = new ArrayList<>(); // list ��ü ����
				do {
					// �ݺ��� ������ ExboardDTO ��ü�� ���� �� ������ ����
					conDetailVO board = new conDetailVO();
					board.setConName(rs.getString("cnt_name"));
					board.setConFromDate(rs.getString("cnt_from_date").substring(0, 10));
					board.setConToDate(rs.getString("cnt_to_date").substring(0, 10));

					list.add(board); // list�� 0�� �ε������� board ��ü�� �������� ����
				} while (rs.next());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(); // DB ���� ���� / Connection ��ȯ
		}
		return list; // list ��ȯ
	}

	// Ķ���� ������ �ʿ��� �޼ҵ�
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

	// �ش� ������ ���� ��¥ ��� �޼ҵ�
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

	// �̹��� ��������
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
	
	//��� ������ ���� ��¥ ��� �޼ҵ�
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
