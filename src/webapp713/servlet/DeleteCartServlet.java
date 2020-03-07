package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.CartItemDao;
import app711.dao.po.User;


@WebServlet("/servlet/delete-cart")
public class DeleteCartServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");//ASCII UTF-8 GBK写在之前
		
		
		
		String product=request.getParameter("product");
		int id=Integer.parseInt(product);
		System.out.println(product);
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("currentUser");
		CartItemDao cartItemDao=new CartItemDao();
		boolean result =false;
		result=cartItemDao.delete(id);
	
		if(result) {
			request.getRequestDispatcher("../page/cart.jsp").forward(request, response);
		}
}
}