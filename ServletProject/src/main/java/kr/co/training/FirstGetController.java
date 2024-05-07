package kr.co.training;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstGet.do")
public class FirstGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstGetController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 왔음");
		String Title = request.getParameter("title");
		String Content = request.getParameter("content");
		
		System.out.println("제목 : " + Title);
		System.out.println("내용 : " + Content);
		
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
