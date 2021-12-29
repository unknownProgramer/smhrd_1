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

@WebServlet("/PersonalContestDeleteService")
public class PersonalContestDeleteAllService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		
		String memId = vo.getMemId();
		
		personalcontestDAO dao = new personalcontestDAO();
		int cnt = dao.deleteAllPersonalConetest(memId);
		
		if(cnt>0){
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		response.sendRedirect("mypageContestJSP.jsp");
	}

}
