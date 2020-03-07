package app711.dao;
//包名 所有存放Dao类都放在此包下
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.User;
import app712.util.DBUtil;

/**
 * Data Access Object
 * 完成数据数据访问的对象-->数据访问对象
 * 类名：参照表名+Dao后缀
 * 
 * @author Admini
 *
 */
public class UserDao {
	public User selectBynameAndPassword(String name,String password) 
			throws SQLException {
		User result=null;
		Connection con=null;
		ResultSet res=null;
		PreparedStatement sta=null;
		try {
			con =DBUtil.getConnection();
			String sql ="select uname,upwd,phone,email from tb_user where "
					+ "uname=? and upwd=?";
			sta= con.prepareStatement(sql);
			//5.参数赋值
			sta.setString(1,name);
			sta.setString(2,password);
			res=sta.executeQuery();
			//7.处理结果
			while(res.next()) {
				result=new User();
				
				result.setName(res.getString("uname"));
				result.setPhone(res.getString("phone"));
				result.setEmail(res.getString("email"));
				result.setPassword(res.getString("upwd"));
			}	
			
		}finally {
			DBUtil.closeAll(con, sta, res);
		}

		return result;
	}
	/**
	 * 
	 * @param usename
	 * @return 如果查到返回记录，否则返回null
	 * @throws SQLException
	 */
	//只返回是否存在该姓名(boolean，通常是满足不了需要的
	//需要返回该用户的所有信息（姓名，密码，年龄，性别）
	//数组？Map？自定义类型User
	//返回值类型如何调整
	public User selectByName(String usename) throws SQLException {//处处 ，900 20，男
		User result1=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try {
			con=DBUtil.getConnection();
			String sql="select uname,upwd,phone,email "
					+ "from tb_user where uname=?";
			sta=con.prepareStatement(sql);
			sta.setString(1,usename);
			//if(sta.setString()
			sta.executeQuery();
			res=sta.executeQuery();
			while(res.next()) {
				result1=new User();
				result1.setName(res.getString("uname"));
				result1.setPassword(res.getString("upwd"));
				result1.setPhone(res.getString("phone"));
				result1.setEmail(res.getString("email"));
				//System.out.println("用户名重复");
			}
	
		} finally {
			
				DBUtil.closeAll(con, sta, res);
		}
		return result1;
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<User> selectAll() throws SQLException {//处处 ，900 20，男
		ArrayList<User> users=new  ArrayList<User>();
		//User[] users=new User[length];//一旦创建长度不可变
		//单查询结果包含多少条记录不固定
		User user1=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try {
			con=DBUtil.getConnection();
			String sql="select uname,upwd,phone from tb_user ";
			sta=con.prepareStatement(sql);
			
			//if(sta.setString()
			sta.executeQuery();
			res=sta.executeQuery();
			while(res.next()) {
				user1=new User();
				//user1.setAge(res.getInt("age"));
				user1.setName(res.getString("uname"));
				user1.setPassword(res.getString("upwd"));
				
				users.add(user1);
				
			}
			
			
		} finally {
			
				DBUtil.closeAll(con, sta, res);
		}
		return users;
	}

	public int insert(User user){
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		conn=DBUtil.getConnection();
		try {
			String sql="Insert into tb_user values (?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getPhone());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return row;
	}
public int updatePasswordByPhoneAndPassword(String phone, String upwd, String npwd) {
	// TODO Auto-generated method stub
	int rows=0;
	Connection con=null;
	PreparedStatement sta=null;
	try {
		
		con=DBUtil.getConnection();
		String sql="update tb_user set upwd=? where phone=? and upwd=?";
		sta=con.prepareStatement(sql);
		sta.setString(1,npwd);
		sta.setString(2,phone);
		sta.setString(3,upwd);
		rows=sta.executeUpdate();
		
	} catch(SQLException e){
		e.printStackTrace();
	}finally {

		DBUtil.closeAll(con, sta, null);
	}
	return rows;
}
/**
 * 通过用户名查找手机号码
 * @param name
 * @return
 */
public User selectPhoneByName(String name) {
	User user=null;
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		conn=DBUtil.getConnection();
		String sql="select *from tb_user where uname=? ";
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		rs=ps.executeQuery();
		if(rs.next()) {
			user=new User();
			user.setName(rs.getString("uname"));
			user.setPassword(rs.getString("upwd"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBUtil.closeAll(conn, ps,rs);
	}
	return user;
}


}
