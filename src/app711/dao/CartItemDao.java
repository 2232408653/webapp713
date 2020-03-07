package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.CartItem;
import app711.dao.po.CartItemAs;
import app712.util.DBUtil;

public class CartItemDao {
	public int insert(String user_id,String product,int count){
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql="Insert into tb_cart_item(user_id,product,count) values (?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, product);
			ps.setInt(3, count);
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return row;
	}
	
	public ArrayList<CartItem> selectByUser(String phone) {
		ArrayList<CartItem> list=new ArrayList<CartItem>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select rid,user_id,isbn,count,title,author,price from tb_book,tb_cart_item "
					+ "where tb_cart_item.product=tb_book.isbn and user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			res=ps.executeQuery();
			while(res.next()) {
				CartItem cartItem=new CartItem();
				cartItem.setUser_id(phone);
				cartItem.setCount(res.getInt("count"));
				cartItem.setTitle(res.getString("title"));
				cartItem.setAuthor(res.getString("author"));
				cartItem.setPrice(res.getDouble("price"));
				cartItem.setIsbn(res.getString("isbn"));
				cartItem.setRid(res.getInt("rid"));
				list.add(cartItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, res);
		}
		return list;
	}
	
	public int selectCountByUserAndProduct(String user_id,String product) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		try {
			conn=DBUtil.getConnection();
			String sql="select count from tb_cart_item where user_id=? and product=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, product);
			rs=ps.executeQuery();
			if(rs.next()) {
				count=rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, rs);
		}
		return count;
	}
	
	public boolean updateCountByUserAndProduct(String user_id,String product,int ncount) {
		boolean result=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql="update tb_cart_item set count=? where user_id=? and product=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ncount);
			ps.setString(2, user_id);
			ps.setString(3, product);
			row=ps.executeUpdate();
			if(row>0)result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return result;
	}
	
	public CartItemAs selectByRid(int rid) {	
        	CartItemAs result =null;
		   Connection con=null;        	  
	       PreparedStatement ps=null;
	       ResultSet rs=null;
	    try {
	    	    con=DBUtil.getConnection();
			    String  sql="select rid,user_id,product, count,title,press,price  "
			    		+ " from tb_cart_item ,tb_book"
			    		+ " where tb_cart_item.product=tb_book.isbn and  rid=?";		     
				ps=con.prepareStatement(sql);        				
				//5.������ֵ
			     ps.setInt(1, rid);
			    rs=ps.executeQuery();		
			    while(rs.next()) {			
					result=new CartItemAs();
					result.setProduct(rs.getString("product"));
					result.setTitle(rs.getString("title"));
					result.setPress(rs.getString("press"));
					result.setPrice(rs.getDouble("price"));
					result.setCount(rs.getInt("count"));  					
					
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
	
	public boolean delete(int id){
		boolean result=false;
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql="delete from tb_cart_item where rid=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			row=ps.executeUpdate();
			if(row>0) 
				result=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return result;
	}

}
