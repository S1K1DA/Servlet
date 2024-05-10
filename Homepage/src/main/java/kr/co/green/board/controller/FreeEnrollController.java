package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/enroll.do")
public class FreeEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); 

		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		// 어떤 사용자가 글작성 요청을 했는지
		HttpSession session = request.getSession();
		int memberNo = (int)session.getAttribute("userNo");
		System.out.println(memberNo);
		
		// DTO에 정보 저장
		FreeDtoImpl freeDto = new FreeDtoImpl();
		freeDto.setBoardTitle(title);
		freeDto.setBoardContent(content);
		freeDto.setMemberNo(memberNo);
		
		// RequestDispatcher           vs            response.sendRedirect
		// jsp로 데이터 담아서 이동할때                     다른 컨트롤러를 다시 요청해야할 때
		
		
		
		// 서비스 호출
		FreeServiceImpl freeService = new FreeServiceImpl();
		int result = freeService.enroll(freeDto);
		
		if(result == 1) {
			response.sendRedirect("/freeBoard/list.do?cpage=1");
		}
		
		
	}

}
