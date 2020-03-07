package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.collectDao;
import app711.dao.po.Collect;
import app711.dao.po.User;

/**
 * 添加收藏
 * Servlet implementation class collect
 */
@WebServlet("/servlet/addcollect")
public class AddCollectServelet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String isbn=request.getParameter("product");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("currentUser");
		Collect collect=new Collect();
		collect.setProduct(isbn);
		collect.setUser_id(user.getPhone());
		collectDao a=new collectDao();
		int row=0;
		PrintWriter out=response.getWriter();
		if(null==a.selectByUser_idAndIsbn(collect.getUser_id(),collect.getProduct())) {
			row=a.insert(collect);
			if(0<row) {
				out.write("yes");
			}
			else {
				out.write("no");
			}
		}else {
			out.write("have");
		}
		
		
		
	}


}
