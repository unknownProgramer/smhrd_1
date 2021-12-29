package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberDAO;
import com.model.memberVO;

@WebServlet("/memberInfoUpdate")
public class memberInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String pw=request.getParameter("pw");
		String name=request.getParameter("name");
		String nick=request.getParameter("nick");
		String email=request.getParameter("email");
		String tel=request.getParameter("tel");
		String add=request.getParameter("add");
		String hi=request.getParameter("hi");
		String id=request.getParameter("memberInfoUpdate");
		
		memberDAO dao=new memberDAO();
		int result=dao.updateMemberInfo(pw, name, nick, email, tel, add, hi, id);
		memberVO vo=dao.login(id, pw);
		
		HttpSession Session=request.getSession();
		
		if(result>0) {
			Session.setAttribute("loginMemberSession", vo);//肺弊牢 技记 犁积己
			response.sendRedirect("memberUpdateSuccess.jsp");
		}else {
			
		}
		
	}
}
