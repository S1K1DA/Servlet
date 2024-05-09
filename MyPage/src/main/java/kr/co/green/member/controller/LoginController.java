package kr.co.green.member.controller;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.member.model.dto.Member;
import kr.co.green.member.model.service.MemberServiceImpl;

@WebServlet("/member/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("useremail");
		String userPwd = request.getParameter("userpassword");
		
		Member member = new Member();
		member.setUserEmail(userEmail);
		member.setUserPwd(userPwd);
		
		System.out.println(userEmail);
		System.out.println(userPwd);
		
		MemberServiceImpl memberService = new MemberServiceImpl();
		Member result = memberService.login(member);
		
		if(Objects.isNull(result.getUserfirstName())) {  // 로그인 실패
			response.sendRedirect("/views/common/error.jsp");
		} else { // 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("userNo", result.getUserNo());
			session.setAttribute("userfirstName", result.getUserfirstName());
			
			RequestDispatcher view = request.getRequestDispatcher("/");
			view.forward(request, response);
			
		}
		
		// 사용자가 입력한 비밀번호 vs 데이터 베이스에 들어있는 비밀번호
		// select count(*) from member
		// where userId = userid
		// and userPwd = userPwd;
		
	}

}