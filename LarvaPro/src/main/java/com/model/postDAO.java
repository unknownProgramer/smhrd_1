package com.model;

public class postDAO extends DBconnection {
	
	//게시판 작성
	public int insertRecruitPost(postVO vo) {
		
		int cnt = 0;
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("insert into recuit_post values(recuit_post_number.nextval,?,?,?,?,?,?,?,?)");
			
			psmt.setString(1, vo.getMemId());
			psmt.setInt(2, vo.getCntNum());
			psmt.setString(3, vo.getRpTitle());
			psmt.setInt(4, vo.getRpMemNum());
			psmt.setInt(5, vo.getRpField());
			psmt.setString(6, vo.getRpContent());
			psmt.setString(7, vo.getRpDate());
			psmt.setInt(8, vo.getRpProgress());
			
			cnt = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
			
	
	//게시판 수정
	
	public int updateRecruitPost(String cntNum, String title, String memNum, String field, String content, String progress ) {
			
			int cnt = 0;
			
			try {
				
				getConnection();
				
		
				psmt = conn.prepareStatement("update recuit_post set cnt_num=?, rp_title=?, rp_mem_num=?, rp_field=?, rp_content=?,  rp_progress=?  where rp_num=?)");
				
				psmt.setString(1, cntNum);
				psmt.setString(2, title);
				psmt.setString(3, memNum);
				psmt.setString(4, field);
				psmt.setString(5, content);
				psmt.setString(6, progress);
				
				cnt = psmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				dbClose();
			}
			return cnt;
		}
	
	//게시판 삭제
	public int deleteRecruitPost(String rpNum) {
	
		int cnt = 0;
		
		try {
		
			getConnection();
			
			psmt = conn.prepareStatement("delete from recruit_post where rp_num=?");
			
			psmt.setString(1, rpNum);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
}

	
}
