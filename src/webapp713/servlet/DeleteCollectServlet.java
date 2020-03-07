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




@WebServlet("/servlet/deletecollect")
public class DeleteCollectServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn=request.getParameter("product");
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("currentUser");
		Collect collect=new Collect();
		collect.setProduct(isbn);
		collect.setUser_id(user.getPhone());
		collectDao a=new collectDao();
		int row=0;
		row=a.deleteByUser_idAndProuducte(collect);
		PrintWriter out=response.getWriter();
		if(row>0) {
			out.write("yes");
		}else {
			out.write("no");
		}

		
	}


}
