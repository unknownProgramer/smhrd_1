package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.teamDAO;

@WebServlet("/deleteTeamService")
public class deleteTeamService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deleteId=Integer.parseInt(request.getParameter("delete"));
		
		teamDAO TDAO = new teamDAO();
		int cnt=TDAO.deleteTeam(deleteId);
		
		if(cnt>0) {
			response.sendRedirect("teamBoardJSP.jsp");
		}
		
	}

}
