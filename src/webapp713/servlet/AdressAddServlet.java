package webapp713.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import app711.dao.AddressDao;
import app711.dao.po.Address;
import app711.dao.po.User;
@WebServlet("/servlet/address-add")
public class AdressAddServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");//ASCII UTF-8 GBK写在之前
		String receiver=request.getParameter("receiver");
		String address=request.getParameter("address");
		String receiverPhone=request.getParameter("receiverPhone");
		AddressDao addressDao=new AddressDao();
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("currentUser");
		Address addr=new Address();
		addr.setReceiver(receiver);
		addr.setAddress(address);
		addr.setReceiverPhone(receiverPhone);
		addr.setUser(user.getPhone());
		int rows=addressDao.insert(addr);
		PrintWriter out=response.getWriter();
		if(rows>0) {
			
			out.write("yes");
		}else {
			out.write("no");
		}
		out.close();
	}
}
