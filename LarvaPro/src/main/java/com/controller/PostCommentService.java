package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.postcommentDAO;
import com.model.postcommentVO;

@WebServlet("/PostCommentService")
public class PostCommentService extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		
		//값 받아오기
		
		String pcMemId  = vo.getMemId();
		String pcContent  = request.getParameter("pcContent");
		String pcDate  = request.getParameter("pcDate");
		
		postcommentVO vo2 = new postcommentVO(pcMemId, pcContent, pcDate);
		postcommentDAO dao = new postcommentDAO();
		
		int cnt = dao.insertPostComment(vo2);
		
		if(cnt>0) {
			System.out.println("댓글 작성 성공");
		} else {
			System.out.println("댓글 작성 실패");
		}
		response.sendRedirect("mypageContestJSP.jsp");
	}

}
