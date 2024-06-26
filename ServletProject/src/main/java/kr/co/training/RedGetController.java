package kr.co.training;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redGet.do")
public class RedGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RedGetController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String addr = request.getParameter("useraddr");
		String email = request.getParameter("useremail");
		String phone = request.getParameter("userphone");
		
		String[] products = request.getParameterValues("product");
		String product2 = "";
		for(String item : products) {
			if(item.equals("gift_3")) {
				product2 += "선물용 3kg";
			} else if(item.equals("gift_5")) {
				product2 += "선물용 5kg";
			} else if(item.equals("family_3")) {
				product2 += "가정용 3kg";
			} else if(item.equals("family_5")) { 
				product2 += "가정용 5kg";
			}
		}
		System.out.println(name + "님이 주문하신 상품은 : " + product2 + " ");
		
		String gifts = request.getParameter("gift");
		 String gift2 = "";
			if(gifts.equals("yes")) {
				gift2 += "합니다";
			} else if(gifts.equals("no")) {
				gift2 += "안합니다";
			}
		System.out.println("선물포장 선택을 " + gift2);
		
		System.out.println("배송 주소 : " + addr);
		System.out.println("이메일 : " + email);
		System.out.println("연락처 : " + phone);

		request.setAttribute("userName", name);
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
