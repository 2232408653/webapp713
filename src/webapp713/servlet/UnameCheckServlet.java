package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app711.dao.UserDao;
import app711.dao.po.User;

/**
 * 检查用户
 * @author Admini
 *
 */
@WebServlet("/servlet/unameCheck")
public class UnameCheckServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String usename=request.getParameter("uname");                
		UserDao userdao=new UserDao();
		User user=null;
		try {
			user=userdao.selectByName(usename);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		if(user!=null) {
			out.print("yes");
		}else {
			out.print("no");
		}
	}
}
