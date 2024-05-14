package kr.co.green.contact.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/detail.do")
public class ContactDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		ContactDto result = contactService.getDetail(no);
		
		request.setAttribute("result", result);
		
		
		
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactDetail.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
