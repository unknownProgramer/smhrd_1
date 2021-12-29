package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.memberDAO;
import com.model.memberVO;
import com.model.teamDAO;
import com.model.teamVO;

@WebServlet("/joinTeamService")
public class joinTeamService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int joinTeamNum=Integer.parseInt(request.getParameter("join"));
		String joinMemberId=request.getParameter("joinMemberId");
		
		teamDAO TDAO=new teamDAO();
		
		teamVO teamLeader=TDAO.selectOneTeam(joinTeamNum);
		teamVO teamJoiner=new teamVO(joinMemberId,teamLeader.getCntNum(),joinTeamNum,1,"±âÈ¹",teamLeader.getTmFull(),null,null);
		
		int cnt=TDAO.createTeam(teamJoiner);
		
		if(cnt>0) {
			response.sendRedirect("teamJoinSuccess.jsp");
		}
	}

}
