package kr.co.green.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberService;
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
		
		// request : 사용자가 요청한 데이터
		// 사용자가 보낸 데이터를 UTF-8로 인코딩 하겠다.
		request.setCharacterEncoding("UTF-8");
		
		// response : 사용가자 응답 할 데이터
		// 사용자에게 응답할 데이터를 UTF-8로 인코딩 하겠다.
		response.setContentType("text/html; charset=UTF-8"); 
		
		String userName = request.getParameter("new-username");
		String userId = request.getParameter("new-userid");
		String userPwd = request.getParameter("new-password");
		String confirmpwd = request.getParameter("confirm-password");
		
		Member member = new Member(); // 객체 생성
		member.setUserName(userName);
		member.setUserId(userId);
		member.setUserPwd(userPwd);
		member.setConfirmpwd(confirmpwd);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		int result = memberService.register(member);
		
		if(result == 1) { // 성공
			RequestDispatcher view = request.getRequestDispatcher("/views/member/login.jsp");
			view.forward(request, response);
		} else { // 실패
			RequestDispatcher view = request.getRequestDispatcher("/views/member/register.jsp");
			view.forward(request, response);
			
		}
		
	}

}
