package kr.co.green.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/duplicateId.do")
public class DuplicateIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DuplicateIdController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userId");
		
		System.out.println("요청 왔음 : " + id);
	}

}
