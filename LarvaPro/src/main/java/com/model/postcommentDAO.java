package com.model;

public class postcommentDAO extends DBconnection {
	
	//��� �Է�
	public int insertPostComment(postcommentVO vo) {
		
		int cnt = 0;
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("insert into post_comment values(post_comment_number.nextval,?,?,?,sysdate,?)");
			
			psmt.setInt(1, vo.getPcCntNum());
			psmt.setString(2, vo.getPcMemId());
			psmt.setString(3, vo.getPcContent());
			psmt.setString(4, vo.getPcDate());
			
			cnt = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	//��� ����
	public int updatePostComment(String content, String num) {
		
		int cnt = 0;
		
		try {
			
			getConnection();
			
			psmt = conn.prepareStatement("update set pc_content=? where pc_num=?)");
			
			psmt.setString(1, content);
			psmt.setString(2, num);
			
			cnt = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	//��� ����
	public int deletePostComment(String pcNum) {
			
		int cnt = 0;
			
		try {
			
			getConnection();
				
			psmt = conn.prepareStatement("delete from post_comment where pc_num=?");
				
			psmt.setString(1, pcNum);
				
			cnt = psmt.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
}
