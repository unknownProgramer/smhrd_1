package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.scoreDAO;
import com.model.scoreVO;

@WebServlet("/ScoreService")
public class ScoreService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//세션 요청
		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		
		//post방식 인코딩
		request.setCharacterEncoding("EUC-KR");
		
		//값 받아오기
		String sendId =  vo.getMemId();
		int receiveScore = Integer.parseInt(request.getParameter("receiveScore"));
		String receiveId = request.getParameter("receiveId");
		
		
		//vo에 저장
		scoreVO vo2 = new scoreVO(sendId, receiveScore, receiveId);
		scoreDAO dao = new scoreDAO();
		
		int cnt = dao.insertScore(vo2);
		
		if(cnt>0) {
			System.out.println("평점 입력 성공");
		} else {
			System.out.println("평점 입력 실패");
		}
		
		response.sendRedirect("mypageTeamJSP.jsp");
		
	}

}
