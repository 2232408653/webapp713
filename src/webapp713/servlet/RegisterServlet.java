package webapp713.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app711.dao.UserDao;
import app711.dao.po.User;


/**
 * 用户注册，插入数据库中
 * @author Admini
 *
 */
@WebServlet("/servlet/register")   
public class RegisterServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("uname");         
		String password=request.getParameter("upwd");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		UserDao userdao=new UserDao();
		User user=userdao.selectPhoneByName(name);
		if(user==null) {
			user=new User(name, password, email, phone);//初始化
			userdao.insert(user);
			request.getRequestDispatcher("../page/login.html").forward(request, response);
		}else {
			
		}
	}
    
}
