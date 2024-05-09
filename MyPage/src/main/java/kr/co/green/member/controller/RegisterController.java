package kr.co.green.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/register.do")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	response.setContentType("text/html; charset=UTF-8");
	
	String userfirstName = request.getParameter("new-firstname");
	String userlastName = request.getParameter("new-lastname");
	String userEmail = request.getParameter("new-email");
	String userPwd = request.getParameter("new-password");
	String confirmpwd = request.getParameter("confirm-password");
	
	Member member = new Member();
	member.setUserfirstName(userfirstName);
	member.setUserlastName(userlastName);
	member.setUserEmail(userEmail);
	member.setUserPwd(userPwd);
	member.setConfirmpwd(confirmpwd);
	
	MemberServiceImpl memberService = new MemberServiceImpl();
	int result = memberService.register(member);
	
	if(result == 1) {
		RequestDispatcher view = request.getRequestDispatcher("/views/member/login.jsp");
		view.forward(request, response);
	} else {
		RequestDispatcher view = request.getRequestDispatcher("/views/member/register.jsp");
		view.forward(request, response);
	}
	
	}

}
