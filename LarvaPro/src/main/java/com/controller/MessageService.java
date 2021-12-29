package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.memberVO;
import com.model.messageDAO;
import com.model.messageVO;

@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���� ��û
		HttpSession session = request.getSession();
		memberVO vo =(memberVO)session.getAttribute("loginMemberSession");
		//post��� ���ڵ�
		request.setCharacterEncoding("EUC-KR");
		
		//�� �޾ƿ���
		String mSendId = vo.getMemId();
		String mReceiveId = request.getParameter("ReceiveId");
		String mContent = request.getParameter("Content");
				
		messageVO vo2 = new messageVO(mSendId, mReceiveId, mContent);
		messageDAO dao = new messageDAO();
				
		int cnt = dao.insertMessage(vo2);
				
		if(cnt>0) {
			System.out.println("�޼��� ���� ����");
		} else {
			System.out.println("�޼��� ���� ����");
		}
	
		response.sendRedirect("mypageMessageJSP.jsp");
	}

}
