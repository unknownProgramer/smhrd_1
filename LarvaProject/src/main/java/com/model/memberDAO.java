package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class memberDAO {
	
	//JDBC연결 메소드		 
	public Connection getConnection() {
	 
	   Connection conn = null;
	   String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
	   String id = "campus_k3_1006";
	   String pw = "smhrd3";
	 
	   try {
	       Class.forName("oracle.jdbc.driver.OracleDriver");
	 
	       conn = DriverManager.getConnection(url, id, pw);
	 
	       return conn;
	   } catch (Exception e) {
	       e.printStackTrace();
	   }
	   return conn;
	}
	
	//회원가입
	public int join(memberVO member) {
		Connection conn=getConnection();
		PreparedStatement psmt=null;
		int cnt=0;
		
		try {
			psmt=conn.prepareStatement("insert into member_info values(?,?,?,?,?,?,?,?)");
			psmt.setString(1, member.getMemId());
			psmt.setString(2, member.getMemPw());
			psmt.setString(3, member.getMemUserName());
			psmt.setString(4, member.getMemNickName());
			psmt.setString(5, member.getMemEmail());
			psmt.setString(6, member.getMemTel());
			psmt.setString(7, member.getMemAdress());
			psmt.setString(8, "sysdate");
					
			cnt=psmt.executeUpdate();
					
		}catch(Exception e){
			System.out.println("회원가입 실패");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				psmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}
}

