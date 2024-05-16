package kr.co.green.contact.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.common.PageInfo;
import kr.co.green.common.Pagination;
import kr.co.green.contact.model.dto.ContactDto;
import kr.co.green.contact.model.service.ContactServiceImpl;

@WebServlet("/contact/list.do")
public class ContactListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ContactListController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 
		
		ContactServiceImpl contactService = new ContactServiceImpl();
		
		int cpage = Integer.parseInt(request.getParameter("cpage"));
		
		int listCount = contactService.getListCount();
		
		int pageLimit = 3;
		
		int boardLimit = 5;
		
		PageInfo pi = Pagination.getPageInfo(listCount, cpage, pageLimit, boardLimit);
		
		ArrayList<ContactDto> list = contactService.getList(pi);
		
		int row = listCount - (cpage - 1) * boardLimit;
		
		request.setAttribute("list", list);
		request.setAttribute("row", row);
		request.setAttribute("pi", pi);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/contact/contactList.jsp");
		view.forward(request, response);
//		int listCount = contactService.getListCount();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
