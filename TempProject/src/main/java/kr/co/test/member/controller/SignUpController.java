package kr.co.test.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.test.member.model.dto.MemberDTO;
import kr.co.test.member.model.service.MemberServiceImpl;

@WebServlet("/signup.do")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignUpController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String name = request.getParameter("new-username");
		String email = request.getParameter("new-userid");
		String password = request.getParameter("new-password");
		String confirmpwd = request.getParameter("confirm-password");
		String birthdate = request.getParameter("birthdate");
		String address = request.getParameter("address");
		
		
		MemberDTO memberDto = new MemberDTO();
		memberDto.setName(name);
		memberDto.setEmail(email);
		memberDto.setPassword(password);
		memberDto.setConfirmpwd(confirmpwd);
		memberDto.setBirthdate(birthdate);
		memberDto.setAddress(address);
		
		memberDto.toString();
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.register(memberDto);
		
		if(result == 1) { // 성공
			RequestDispatcher view = request.getRequestDispatcher("/views/member/login.jsp");
			view.forward(request, response);
		} else { // 실패
			RequestDispatcher view = request.getRequestDispatcher("/views/common/error.jsp");
			view.forward(request, response);
			
		}
		
		
	
	
	}

}
