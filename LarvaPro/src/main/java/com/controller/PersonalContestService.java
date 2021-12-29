package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.personalcontestDAO;
import com.model.personalcontestVO;

@WebServlet("/PersonalContestService")
public class PersonalContestService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		
		request.setCharacterEncoding("EUC-KR");
		
		//값 받아오기
		
		String memId  = vo.getMemId();
		int cntNum  = Integer.parseInt(request.getParameter("cntNum"));
		String pcntPosition  = request.getParameter("pcntPosition");
		String pcntContent = request.getParameter("pcntContent");
		int pcntType = Integer.parseInt(request.getParameter("pcntType"));
		
		personalcontestVO vo2 = new personalcontestVO(memId, cntNum, pcntPosition, pcntContent, pcntType);
		personalcontestDAO dao = new personalcontestDAO();
		
		int cnt = dao.insertPersonalConetest(vo2);
		
		if(cnt>0) {
			System.out.println("공모전 내역 작성 성공");
		} else {
			System.out.println("공모전 내역 작성 실패");
		}
		
		response.sendRedirect("mypageContestJSP.jsp");
	}
}
