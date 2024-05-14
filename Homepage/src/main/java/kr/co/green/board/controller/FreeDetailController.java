package kr.co.green.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/freeBoard/detail.do")
public class FreeDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FreeDetailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int boardNo = Integer.parseInt(request.getParameter("boardNo"));
		// boardNo를 가지고 게시글의 정보 불러오기
		FreeServiceImpl freeService = new FreeServiceImpl();
		FreeDtoImpl result = freeService.getDetail(boardNo);
		
		
		// 필요한 정보: 제목, 내용, 작성일, 조회수, 작성자
		// 조회수 1증가 
		result.setBoardViews(result.getBoardViews()+1);
		
		
		request.setAttribute("result", result);
		
		
		
		
		RequestDispatcher view = request.getRequestDispatcher("/views/board/free/freeDetail.jsp");
		view.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
