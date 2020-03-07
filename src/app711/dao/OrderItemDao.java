package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.Order;
import app711.dao.po.OrderItem;
import app712.util.DBUtil;

public class OrderItemDao {
	public int insert(Order order) {
		Order order1=order;
      	int rows=0;
      	Connection con=null;        	  
  	    PreparedStatement ps=null;
  	 
  	    try {
  	    	    con=DBUtil.getConnection();
  			    String  sql="insert into "
  			    		+ "tb_order_item(product,price,count,order_id)  values(?,?,?,?) ";		   	   
  				ps=con.prepareStatement(sql);
  				//5.������ֵ
  				ps.setString(1, order1.getProduct());
  				ps.setDouble(2, order1.getPrice());
  				ps.setInt(3, order1.getCount());
  				ps.setString(4, order1.getOrder_id());
  				//System.out.println("不正常");
  			    rows=ps.executeUpdate();		
  		         ps.close();
  		         con.close();
  			}
  			
  			catch(SQLException e1) {
  				e1.printStackTrace();
  			}
  			finally {    //��ֹclass.forname();����
  				DBUtil.closeAll(con, ps, null);  		  
  		  }
   return rows;
      }
	
	public ArrayList<OrderItem> selectAllByOrder_id(String  user_id){
		ArrayList<OrderItem> collects=new ArrayList<OrderItem>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		OrderItem collect=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tb_order_item where order_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			res=ps.executeQuery();
			while(res.next()){
				collect=new OrderItem();
				collect.setRid(res.getInt("rid"));
				collect.setCount(res.getInt("count"));
				collect.setProduct(res.getString("product"));
				collect.setOrder_id(res.getString("order_id"));
				collect.setPrice(res.getDouble("price"));
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
}
