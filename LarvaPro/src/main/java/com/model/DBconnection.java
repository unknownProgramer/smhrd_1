package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnection {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	//db ����
	public void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_k3_1006";
			String password = "smhrd3";
					
			//2. �����ͺ��̽� ���� ��ü(Connection) ����
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		}
	}
	
	//db ���� ����
	public void dbClose() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(psmt != null) {
				psmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch (Exception e) {
			System.out.println("������������");
			e.printStackTrace();
		}
	}
}
