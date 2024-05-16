package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/answer.do")
public class ContactAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactAnswerController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		
		HttpSession session = request.getSession();
		int mNo = (int)session.getAttribute("userNo");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String answerContent = request.getParameter("content");
		
		ContactDto contactDto = new ContactDto();
		contactDto.setAnswerContent(answerContent);
		contactDto.setNo(no);
		contactDto.setMemberNo(mNo);
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		
		int result = contactService.setAnswer(contactDto);
		
		if(result == 1) {
			response.sendRedirect("/contact/list.do?cpage=1");
		}
	}

}
