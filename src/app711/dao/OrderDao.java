package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import app711.dao.po.Collect;
import app711.dao.po.Order;
import app712.util.DBUtil;
/**
 * 在tb_order中插入数据
 * @author Admini
 *
 */
public class OrderDao {
	public int insert(String user_id,String order_id,int address_id,String sta){
		Connection conn=null;
		PreparedStatement ps=null;
		int rows=0;
		try {
			conn=DBUtil.getConnection();
			String sql="insert into tb_order(user_id,order_id,address_id,sta) values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, order_id);
			ps.setInt(3, address_id);
			ps.setString(4, sta);
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return rows;
	}
	
	public int updateStaByOrder_id(String order_id) {
		// TODO Auto-generated method stub
		int rows=0;
		Connection con=null;
		PreparedStatement sta=null;
		try {
			
			con=DBUtil.getConnection();
			String sql="update tb_order set sta=? where order_id=?";
			sta=con.prepareStatement(sql);
			sta.setString(1,"yishouhuo");
			sta.setString(2,order_id);
			
			rows=sta.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		}finally {

			DBUtil.closeAll(con, sta, null);
		}
		return rows;
	}
	
	public ArrayList<Order> selectAllByUser_id(String  user_id){
		ArrayList<Order> orders=new ArrayList<Order>();
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		Collect collect=null;
		Order order=null;
		try {
			con=DBUtil.getConnection();
			String sql="select * from tb_order where user_id=?";
			sta=con.prepareStatement(sql);
			sta.setString(1, user_id);
			res=sta.executeQuery();
			while(res.next()){
				order=new Order();
				order.setRid(res.getInt("rid"));
				order.setAddress_id(res.getInt("address_id"));
				order.setUser_id(res.getString("user_id"));
				order.setSta(res.getString("sta"));
				order.setOrder_id(res.getString("order_id"));
				order.setPayment(res.getDouble("payment"));
				order.setPlaced(res.getTimestamp("placed"));
				order.setReceipt(res.getTimestamp("receipt"));
				order.setDeliver(res.getTimestamp("deliver"));
				order.setHandover(res.getTimestamp("handover"));
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(con, sta, res);
		}
		return orders;
	}
	

	public ArrayList<Order> selectAll() throws SQLException {
		ArrayList<Order> orders=new ArrayList<Order>();
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		Order order=null;
		try {
			con=DBUtil.getConnection();
			String sql="select * from tb_order_item,tb_order "
					+ "where tb_order_item.order_id=tb_order.order_id ";
			sta=con.prepareStatement(sql);
			sta.executeQuery();
			res=sta.executeQuery();
			while(res.next()) {
				order=new Order();
				order.setRid(res.getInt("rid"));
				order.setProduct(res.getString("product"));
				order.setCount(res.getInt("count"));
				order.setOrder_id(res.getString("order_id"));
				order.setPrice(res.getDouble("price"));	
				order.setPayment(res.getDouble("payment"));
				order.setPlaced(res.getTimestamp("placed"));
				order.setReceipt(res.getTimestamp("receipt"));
				order.setDeliver(res.getTimestamp("deliver"));
				order.setHandover(res.getTimestamp("handover"));
				order.setSta(res.getString("sta"));
				order.setUser_id(res.getString("user_id"));
				orders.add(order);
			}
			
		} finally {
			
				DBUtil.closeAll(con, sta, res);
		}
		return orders;
	}
	
	public int updated(int a)
	  {
		  int v=0;
		  OrderDao l=new OrderDao();
		  String user_id=l.selectOrderId();
		  System.out.println(user_id);
		  Connection con=null;        	  
 	   PreparedStatement ps=null;
 	   
 	    try {
 	    	    con=DBUtil.getConnection();
 			    String  sql="update tb_order set address_id=?"
 			    		+ "  where order_id=? ";		   
 			  	   
 				ps=con.prepareStatement(sql);
  				ps.setInt(1,a);
 				ps.setString(2, user_id);			
 			    v=ps.executeUpdate();		
 			 	ps.close();
 		         con.close();
 			}
 			catch(SQLException e1) {
 				
 				e1.printStackTrace();
 			}
 			finally {   
 				DBUtil.closeAll(con, ps, null);
 		  
 		  }
 	   return v;
	  }
	
	
	public String selectOrderId() {	
		   String s=null;
		Connection con=null;        	  
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    try {
	    	    con=DBUtil.getConnection();
	    	    String  sql="select order_id  from  tb_order  ";		      
				ps=con.prepareStatement(sql);
			    rs=ps.executeQuery();		
				while(rs.next()) {			
					
					s=rs.getString("order_id");
					
				}
			    rs.close();
		         ps.close();
		         con.close();
			}
			catch(SQLException e1) {
				
				e1.printStackTrace();
			}
			finally {   
				DBUtil.closeAll(con, ps, rs);
		  
		  }
	    System.out.println(s);
		return  s;		
	}
	
	 public Order selectOrderAll() {	
		  
         Order result =new Order();
		 int v=0;
		 OrderDao l=new OrderDao();
		String user_id=l.selectOrderId();
		String s=null;
 		Connection con=null;        	  
 	    PreparedStatement ps=null;
 	    ResultSet rs=null;
 	    try {
 	    	    con=DBUtil.getConnection();
 			    String  sql="select *  from  tb_order  where order_id=?";		   	   
 				ps=con.prepareStatement(sql);
 				//ֵ
 				ps.setString(1, user_id);
 			    rs=ps.executeQuery();		
 			    while(rs.next()) {			
 					
 					result.setPayment(rs.getDouble("payment"));
 					result.setOrder_id(user_id);
 					result.setUser_id(rs.getString("user_id"));
 				
 				} 			
 			    rs.close();
 		         ps.close();
 		         con.close();
 			}
 			
 			catch(SQLException e1) {
 				
 				e1.printStackTrace();
 			}
 			finally {    
 				DBUtil.closeAll(con, ps, rs);
 		  }
		return  result;		
 	}
	 
	 public int insert(Order order) {

	      	int rows=0;
	      	Connection con=null;        	  
	  	    PreparedStatement ps=null;
	  	 
	  	    try {
	  	    	    con=DBUtil.getConnection();
	  			    String  sql="insert into tb_order(user_id,order_id,sta,address_id,payment) "
	  			    		 +" values(?,?,?,?,?) ";		      
	  				ps=con.prepareStatement(sql);
	  				ps.setString(1, order.getUser_id());
	  				ps.setString(2, order.getOrder_id());	
	  				ps.setString(3, order.getSta());
	  				ps.setString(4, order.getAddress_id1());
	  				ps.setDouble(5, order.getPayment());
	  			    rows=ps.executeUpdate();		
	  			ps.close();
	  		         con.close();
	  			}
	  			
	  			catch(SQLException e1) {
	  				
	  				e1.printStackTrace();
	  			}
	  			finally {    
	  				DBUtil.closeAll(con, ps, null);
	  		  }
	      	
	      	return rows;
	      }
	 
	 public ArrayList<Order> selectByPhone(String phone){
			ArrayList<Order> list = new ArrayList<Order>();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null;	
			Order orders = null; 
			String sql = "select tb_order.rid,user_id,tb_order.order_id,sta,address_id,payment,placed,receipt,deliver,handover,product,tb_order_item.price,count,isbn,title,author,press from tb_order,tb_order_item,tb_book where tb_order.order_id=tb_order_item.order_id and tb_order_item.product=tb_book.isbn and user_id=?";
			try {
				con = DBUtil.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(1, phone);
				rs = ps.executeQuery();
				while(rs.next()) {
					orders=new Order();
					orders.setRid(rs.getInt("rid"));
					orders.setUser_id(rs.getString("user_id"));
					orders.setOrder_id(rs.getString("tb_order.order_id"));
					orders.setSta(rs.getString("sta"));
					orders.setAddress_id(rs.getInt("address_id"));
					orders.setPayment(rs.getDouble("payment"));
					orders.setPlaced(rs.getTimestamp("placed"));
					orders.setReceipt(rs.getTimestamp("receipt"));
					orders.setDeliver(rs.getTimestamp("deliver"));
					orders.setHandover(rs.getTimestamp("handover"));
					orders.setProduct(rs.getString("product"));
					orders.setPrice(rs.getDouble("price"));
					orders.setCount(rs.getInt("count"));
					orders.setTitle(rs.getString("title"));
					orders.setPress(rs.getString("press"));
					list.add(orders);
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.closeAll(con, ps, rs);
			}
			return list;
		}
	 
	 public ArrayList<Order> selectAllByOrder_id(String  order_id){
			ArrayList<Order> collects=new ArrayList<Order>();
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet res=null;
			Order collect=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from tb_order where user_id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, order_id);
				res=ps.executeQuery();
				while(res.next()){
					collect=new Order();
					collect.setRid(res.getInt("rid"));
					collect.setAddress_id(res.getInt("address_id"));
					collect.setOrder_id(res.getString("order_id"));
					collect.setPayment(res.getInt("payment"));
					collect.setSta(res.getString("sta"));
					collects.add(collect);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(conn, ps, res);
			}
			return collects;
		}
	 
	 public Order selectByOrder_id2(String  order_id){
			
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet res=null;
			Order collect=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from tb_order where order_id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, order_id);
				res=ps.executeQuery();
				while(res.next()){
					collect=new Order();
					collect.setRid(res.getInt("rid"));
					collect.setAddress_id(res.getInt("address_id"));
					collect.setOrder_id(res.getString("order_id"));
					collect.setPayment(res.getInt("payment"));
					collect.setSta(res.getString("sta"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				DBUtil.closeAll(conn, ps, res);
			}
			return collect;
		}

}
