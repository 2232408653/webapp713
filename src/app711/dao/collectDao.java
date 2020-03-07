package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.Collect;
import app712.util.DBUtil;

public class collectDao {
	public ArrayList<Collect> selectCollectAllByUser_id(String  user_id){
		ArrayList<Collect> collects=new ArrayList<Collect>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		Collect collect=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tb_collect where user_id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			res=ps.executeQuery();
			while(res.next()){
				collect=new Collect();
				collect.setRid(res.getInt("rid"));
				collect.setProduct(res.getString("product"));
				collect.setUser_id(res.getString("user_id"));
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
	
	public Collect selectByUser_idAndIsbn(String user_id,String Isbn){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet res=null;
		Collect collect=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select * from tb_collect WHERE user_id=? and product=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, user_id);
			ps.setString(2, Isbn);
			res=ps.executeQuery();
			if(res.next()) {
				collect=new Collect();
				collect.setRid(res.getInt("rid"));
				collect.setProduct(res.getString("product"));
				collect.setUser_id(res.getString("user_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(conn, ps, res);
		}
		return collect;
	}
	public int insert(Collect collect){
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql=" insert into tb_collect values (?,?,?) ";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, collect.getRid());
			ps.setString(2, collect.getUser_id());
			ps.setString(3, collect.getProduct());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return row;
		
	}
	public int deleteByUser_idAndProuducte(Collect collect){
		Connection conn=null;
		PreparedStatement ps=null;
		int row=0;
		try {
			conn=DBUtil.getConnection();
			String sql=" delete from tb_collect where user_id=? and product=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, collect.getUser_id());
			ps.setString(2, collect.getProduct());
			row=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtil.closeAll(conn, ps, null);
		}
		return row;
		
	}

}
