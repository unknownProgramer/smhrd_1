package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.conDetailVO;
import com.model.searchDAO;

@WebServlet("/searchService")
public class searchService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		searchDAO dao = new searchDAO();
		String search = request.getParameter("search");

		ArrayList<conDetailVO> vo = dao.searchThings("%" + search + "%");

		request.setAttribute("search", vo);
		RequestDispatcher rd = request.getRequestDispatcher("searchResultJSP.jsp");
		rd.forward(request, response);

	}

}
