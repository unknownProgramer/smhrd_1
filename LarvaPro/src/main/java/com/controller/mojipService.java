package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.teamDAO;
import com.model.teamVO;

@WebServlet("/mojipService")
public class mojipService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		  request.setCharacterEncoding("UTF-8");
		  
		  String strCntNum = request.getParameter("cntNum"); int cntNum =
		  Integer.valueOf(strCntNum);
		  
		  String title = request.getParameter("title"); String position =
		  request.getParameter("position"); String strFull =
		  request.getParameter("full"); int full = Integer.valueOf(strFull);
		  
		  String content = request.getParameter("content"); String memberId =
		  request.getParameter("memberId");
		 
		teamDAO TDAO = new teamDAO();
		int max = TDAO.maxTeam();
		
		System.out.println(max);

		
		  teamVO leaderTeam = new teamVO(memberId, cntNum, max, 0, position, full,
		  title, content); int result = TDAO.createTeamLeader(leaderTeam);
		  
		  
		  if (result > 0) { response.sendRedirect("makeTeamSuccess.jsp"); }
		 
		
		
		
		
	}

}
