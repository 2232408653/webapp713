package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.OrderDao;
import app711.dao.po.User;
@WebServlet("/servlet/confirmReceipt")
public class ConfirmReceiptServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");//ASCII UTF-8 GBK写在之前
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("currentUser");
		String order_id=request.getParameter("order_id");
		//int  address_id=2;
		//String sta="已收货";
		OrderDao orderDao=new OrderDao();
		int rows=orderDao.updateStaByOrder_id(order_id);
		PrintWriter out=response.getWriter();
		if(rows>0) {
			out.write("yes");
		}else {
			out.write("no");
		}
		out.close();
	}
}
