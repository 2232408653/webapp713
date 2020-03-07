package webapp713.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.BookDao;
import app711.dao.UserDao;
import app711.dao.po.Book;
import app711.dao.po.User;

@WebServlet("/servlet/login")
public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取数据
		request.setCharacterEncoding("UTF-8");//ASCII UTF-8 GBK写在之前
		String name=request.getParameter("uname");
		String password=request.getParameter("upwd");
		//处理数据:验证账户信息
		boolean boo=false;
		//if(name.equals("tom")&&password.equals("000")) {
		//	boo=true;
		//}
		UserDao userDao=new UserDao();
		User u1=null;
		try {
			 u1=userDao.selectBynameAndPassword(name, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		if(null!=u1){
//			boo=true;
//		}
		//根据处理结果响应:通过验证去index.html否则去fail.html
		if(null!=u1) {
			BookDao bookDao=new BookDao();
			try {
				ArrayList<Book> books=bookDao.selectBookAll();
				request.setAttribute("books", books);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("currentUser", u1);
			
		
			request.getRequestDispatcher("/page/index.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/page/login.html").forward(request, response);
		}
		
		
		
	}

	

}
