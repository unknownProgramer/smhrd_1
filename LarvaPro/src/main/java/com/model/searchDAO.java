package com.model;

import java.util.ArrayList;

public class searchDAO extends DBconnection{
	
	public ArrayList<conDetailVO> searchThings(String search) {
		
		getConnection();
		ArrayList<conDetailVO> searchList = new ArrayList<conDetailVO>();
		
		int conNum=0;
		String conName=null;
		String conHost=null;
		String conField=null;
		String conQualfication=null;
		String conFromDate=null;
		String conToDate=null;
		String conHomePage=null;
		String conPostBig=null;
		String conPostSmall=null;
		String conContent=null;
		
		try {
			psmt = conn.prepareStatement("select * from contest where cnt_name like ?");
			
			psmt.setString(1,search);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				conNum=rs.getInt(1);
				conName=rs.getString(2);
				conHost=rs.getString(3);
				conField=rs.getString(4);
				conQualfication=rs.getString(5);
				conFromDate=rs.getString(6);
				conToDate=rs.getString(7);
				conHomePage=rs.getString(8);
				conPostSmall=rs.getString(9);
				conPostBig=rs.getString(10);
				conContent=rs.getString(11);
				
				System.out.println(conNum);
				System.out.println(conHost);
				System.out.println(conField);
				System.out.println(conQualfication);
				System.out.println(conFromDate);
				System.out.println(conToDate);
				System.out.println(conHomePage);
				System.out.println(conPostBig);
				System.out.println(conPostSmall);
				System.out.print(conContent);
				
				conDetailVO vo=new conDetailVO(conNum, conName, conHost, conField, conQualfication, conFromDate, conToDate, conHomePage, conPostBig, conPostSmall, conContent);
				searchList.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			dbClose();
		}return searchList;
	}
	
	}


