package kr.co.green.contact.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/delete.do")
public class ContactDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactDeleteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		int result = contactService.Delete(no);
		
//		request.setAttribute("result", result);
		
		if(result == 1) {
			response.sendRedirect("/contact/list.do?cpage=1");
		}
		
	}

}
