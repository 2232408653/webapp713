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


@WebServlet("/servlet/cart-add")
public class CartAddServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String count=request.getParameter("count");                  
		String product=request.getParameter("product");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("currentUser");
		CartItemDao cartItemDao =new CartItemDao();
		int ocount=cartItemDao.selectCountByUserAndProduct(user.getPhone(), product);
		boolean cart_add=false;
		if(ocount>0) {
			int ncount=Integer.parseInt(count)+ocount;
			cartItemDao.updateCountByUserAndProduct(user.getPhone(), product, ncount);
			cart_add=true;
		}else {
			cartItemDao.insert(user.getPhone(),product,Integer.parseInt(count));
			cart_add=true;
		}
		PrintWriter out=response.getWriter();
		if(cart_add) {
			//yes
			out.write("yes");
		}else {
			//no
			out.write("no");
		}
		out.close();
	}
}
