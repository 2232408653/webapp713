package webapp713.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/servlet/logout")
public class LogoutServlet extends LoginServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("currentUser");
		request.getRequestDispatcher("/page/login.html").forward(request, response);
	}
}
