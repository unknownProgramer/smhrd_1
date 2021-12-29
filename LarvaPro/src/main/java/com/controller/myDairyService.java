package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.personalcontestDAO;

@WebServlet("/myDairyService")
public class myDairyService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		if(request.getParameter("delete")!=null) {
			personalcontestDAO PSDAO=new personalcontestDAO();
			PSDAO.deleteOnePersonalConetest(request.getParameter("contestNum"));
		}
		String myConCnt = request.getParameter("contestNum");
		String myConRole = request.getParameter("position");
		String myDairy = request.getParameter("Dairy");

		personalcontestDAO PSDAO = new personalcontestDAO();
		int result = PSDAO.updateDairy(myConCnt,myConRole,myDairy);

		if (result > 0) {
			response.sendRedirect("mypageProfileJSP.jsp");
		}
	}

}
