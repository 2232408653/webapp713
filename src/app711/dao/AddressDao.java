package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.Address;
import app712.util.DBUtil;

public class AddressDao {
	public int insert(Address address) {
		int rows=0;
		Connection con=null;
		PreparedStatement sta=null;
		try {
			
			con=DBUtil.getConnection();
			String sql="insert into  tb_address (user_id,added,receiver,address,receiver_phone) "
					+ "values(?,?,?,?,?)";
			sta=con.prepareStatement(sql);
			//Date date = new Date(new java.util.Date().getTime());
			//String usename = null;
			sta.setString(1,address.getUser());
			sta.setTimestamp(2, new java.sql.Timestamp(new java.util.Date().getTime()));
			sta.setString(3,address.getReceiver());
			sta.setString(4,address.getAddress());
			sta.setString(5,address.getReceiverPhone());
			
			rows=sta.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		}finally {

			DBUtil.closeAll(con, sta, null);
		}
		return rows;
	}
	
	
	 public ArrayList<Address> selectAll() {	
         ArrayList<Address>  list =new ArrayList();
         Address result =null;
 		Connection con=null;        	  
 	    PreparedStatement ps=null;
 	    ResultSet rs=null;
 	    try {
 	    	    con=DBUtil.getConnection();
 			    String  sql="select rid,user_id,address,receiver,receiver_phone  from  tb_address  ";		   
    
 				ps=con.prepareStatement(sql);
 			    rs=ps.executeQuery();		    
 			    while(rs.next()) {			
 					result=new Address();
 					result.setRid(rs.getInt("rid"));
 					result.setUser(rs.getString("user_id"));
 					result.setAddress(rs.getString("address"));
 					result.setReceiver(rs.getString("receiver"));
 					result.setReceiverPhone(rs.getString("receiver_phone"));
 					list.add(result);
 				} 
 			    rs.close();
 		         ps.close();
 		         con.close();
 			}
 			catch(SQLException e1) {
 				
 				e1.printStackTrace();
 			}
 			finally {    //  ֹclass.forname();    
 				DBUtil.closeAll(con, ps, rs);
 		  }
 		return  list;		
 	}
	 
	 public Address selectByID(int id){
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet res=null;
			Address address=null;
			try {
				conn=DBUtil.getConnection();
				String sql="select * from tb_address where rid=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, id);
				res=ps.executeQuery();
				if(res.next()) {
					address=new Address();
					address.setRid(res.getInt("rid"));
					address.setUser(res.getString("user_id"));
					address.setAddress(res.getString("address"));
					address.setAdded(res.getDate("added"));
					address.setReceiver(res.getString("receiver"));
					address.setReceiverPhone(res.getString("receiver_phone"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return address;
		}

}
