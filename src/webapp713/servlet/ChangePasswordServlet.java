package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.UserDao;
import app711.dao.po.User;
@WebServlet("/servlet/change-password")
public class ChangePasswordServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");//ASCII UTF-8 GBK写在之前
		String upwd=request.getParameter("upwd");
		String npwd=request.getParameter("npwd");
		UserDao userDao=new UserDao();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("currentUser");
		int rows=userDao.updatePasswordByPhoneAndPassword(user.getPhone(),upwd,npwd);
		PrintWriter out=response.getWriter();
		if(rows>0) {
			session.removeAttribute("currentUser");
			out.write("yes");
		}else {
			out.write("no");
		}
		out.close();
	}
}
