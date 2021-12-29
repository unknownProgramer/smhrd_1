package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.personalcontestDAO;

@WebServlet("/PersonalContentDeleteOneService")
public class PersonalContentDeleteOneService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pcntNum = request.getParameter("pcntNum");
		
		personalcontestDAO dao = new personalcontestDAO();
		int cnt = dao.deleteOnePersonalConetest(pcntNum);
		
		if(cnt>0){
			System.out.println("������ ���� �ϳ� ���� ����");
		} else {
			System.out.println("������ ���� �ϳ� ���� ����");
		}
		response.sendRedirect("mypageContestJSP.jsp");
	}

}
