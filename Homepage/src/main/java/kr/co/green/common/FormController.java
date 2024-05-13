package kr.co.green.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.green.board.model.dto.FreeDtoImpl;
import kr.co.green.board.model.service.FreeServiceImpl;

@WebServlet("/form/*")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");

		String action = request.getPathInfo();
		String nextPage = "";

		if (action.equals("/registerForm.do")) {
			nextPage = "/views/member/register.jsp";
		} else if (action.equals("/loginForm.do")) {
			nextPage = "/views/member/login.jsp";
		} else if (action.equals("/enrollForm.do")) {
			nextPage = "/views/board/free/freeEnroll.jsp";
		} else if (action.equals("/editForm.do")) {
			int boardNo = Integer.parseInt(request.getParameter("boardNo"));
			
			FreeServiceImpl freeService = new FreeServiceImpl();
			FreeDtoImpl result = freeService.getEditForm(boardNo);
			
			request.setAttribute("result", result);
			nextPage = "/views/board/free/freeEdit.jsp";
			
			
			
		}
			
		if (nextPage != null && !nextPage.isEmpty()) {
			RequestDispatcher view = request.getRequestDispatcher(nextPage);
			view.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
