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
		
		//���� ��û
		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		
		//post��� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		
		//�� �޾ƿ���
		String sendId =  vo.getMemId();
		int receiveScore = Integer.parseInt(request.getParameter("receiveScore"));
		String receiveId = request.getParameter("receiveId");
		
		
		//vo�� ����
		scoreVO vo2 = new scoreVO(sendId, receiveScore, receiveId);
		scoreDAO dao = new scoreDAO();
		
		int cnt = dao.insertScore(vo2);
		
		if(cnt>0) {
			System.out.println("���� �Է� ����");
		} else {
			System.out.println("���� �Է� ����");
		}
		
		response.sendRedirect("mypageTeamJSP.jsp");
		
	}

}
