package webapp713.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app711.dao.CartItemDao;
import app711.dao.OrderDao;
import app711.dao.OrderItemDao;
import app711.dao.po.CartItemAs;
import app711.dao.po.Order;
import app711.dao.po.User;

@WebServlet("/servlet/order-create")
public class OrderCreateServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  String[] itemIds=request.getParameterValues("itemIds");
		  HttpSession session=request.getSession();
		  User user=(User) session.getAttribute("currentUser");
		  Order order=new Order();
		  CartItemAs cartItemAs =new CartItemAs ();
		  CartItemDao cartItemDao=new CartItemDao();
		  int rid=0;
		  order.setUser_id(user.getPhone());
	      order.setSta("已支付");
	      String orderId =user.getPhone().substring(8)+new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
	      String []itemId=itemIds[0].split(",");
		  OrderItemDao od=new OrderItemDao();
		 
		  double sum=0;
		  for(int j=0;j<itemId.length;j++){
			  rid=Integer.parseInt(itemId[j]);
			   cartItemAs = cartItemDao.selectByRid(rid);
			   Order or=new Order();
				or.setOrder_id(orderId);
				or.setPrice(cartItemAs.getPrice());
				or.setProduct(cartItemAs.getProduct());
				or.setCount(cartItemAs.getCount());
				od.insert(or);
				
				sum+=cartItemAs.getPrice()*cartItemAs.getCount();
		  }
		  order.setAddress_id1("1");
		  order.setPayment(sum);
		  order.setOrder_id(orderId);
	      OrderDao orderDao=new OrderDao();
	      int rows=orderDao.insert(order);
	      
	      if(0<rows) {
	    	  	
	    	      	  request.getRequestDispatcher("/page/order-confirm.jsp").forward(request, response);

	      } else {
	    	  
	    	  System.out.println("error");
	      }
		}

}
