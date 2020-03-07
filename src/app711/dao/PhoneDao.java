package app711.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PhoneDao {
/**
 * 
 * @param pname 手机名
 * @param address 地址
 * @param color 颜色
 * @return 
 * @throws SQLException
 */
	public int insert(String pname,String address,String color) throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/xia";
		String user="root";
		String password1="123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password1);
			String sql="insert into use_info (pname,address,color) values(?,?,?)";
			PreparedStatement sta=con.prepareStatement(sql);
			sta.setString(1,pname);
			sta.setString(2,address);
			sta.setString(3,color);
			int rows=sta.executeUpdate();
			System.out.println("影响了"+rows+"行");
			
			con.close();
			sta.close();
			return rows;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}
/**
 * 
 * @param pname
 * @return 如果删除成功，返回行数
 * @throws SQLException
 */
public int deleteByPname(String pname) throws SQLException {
		
		String url="jdbc:mysql://localhost:3306/xia";
		String user="root";
		String password1="123456";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,user,password1);
			String sql="delete from phone where pname=?";
			PreparedStatement sta=con.prepareStatement(sql);
			sta.setString(1,pname);
			int rows=sta.executeUpdate();
			System.out.println("影响了"+rows+"行");
			
			con.close();
			sta.close();
			return rows;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

  }

public boolean updataPasswordByPnameAndAddress(String pname,String address,String color) throws SQLException {
	boolean result =false;
	String url="jdbc:mysql://localhost:3306/xia";
	String user="root";
	String password1="123456";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,user,password1);
		String sql="update phone set color where pname=?";
		PreparedStatement sta=con.prepareStatement(sql);
		sta.setString(1,pname);
		int rows=sta.executeUpdate();
		System.out.println("影响了"+rows+"行");
		
		con.close();
		sta.close();
		if(rows!=0) {return result=true;}
		else {return result; }
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	return result;
}
}
