package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.personalcontestVO;
import com.model.scoreVO;


import com.model.memberDAO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("loginId");
		String pw=request.getParameter("loginPw");
		
		memberDAO Login=new memberDAO();
		memberVO memberInfo=Login.login(id,pw);
		
		HttpSession Session=request.getSession();
		
		
		if(memberInfo!=null) {
			System.out.println("�α��� ����");
			Session.setAttribute("loginMemberSession", memberInfo);//�α��� ���� ����
			response.sendRedirect("LoginJSP.jsp");
		}else if(memberInfo==null) {
			System.out.print("�α��� ����");
			Session.setAttribute("loginMemberFail", "fail");
			response.sendRedirect("LoginJSP.jsp");
		}
		
	}

}
