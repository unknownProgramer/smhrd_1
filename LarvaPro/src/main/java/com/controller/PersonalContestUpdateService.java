package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.personalcontestDAO;

@WebServlet("/PersonalContestUpdateService")
public class PersonalContestUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cntNum = request.getParameter("cntNum");
		String position = request.getParameter("position"); 
		String content = request.getParameter("content"); 
		String type = request.getParameter("type"); 
		String pcNum = request.getParameter("pcNum"); 
		
		personalcontestDAO dao = new personalcontestDAO();
		int cnt = dao.updatePersonalContest(cntNum, position, content, type, pcNum);
		
		if (cnt>0) {
			System.out.println("공모전 내역 삭제 성공");
		}else {
			System.out.println("공모전 내역 삭제 실패");
		}
		response.sendRedirect("mypageContestJSP.jsp");
	}

}
