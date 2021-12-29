package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.postcommentDAO;

@WebServlet("/PostCommentUpdateService")
public class PostCommentUpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content = request.getParameter("content");
		String num = request.getParameter("num"); 
		
		postcommentDAO dao = new postcommentDAO();
		int cnt = dao.updatePostComment(content, num);
		
		if (cnt>0) {
			System.out.println("댓글 수정 성공");
		}else {
			System.out.println("댓글 수정 실패");
		}
		response.sendRedirect("main.jsp");
	}

}
