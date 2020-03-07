package app712.util;
/***
 * @author 15185丁硕
 * 数据库连接工具包
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	static String rootName="ds";
	static String rootPwd="root";
	static String DBName="user";
	static String DBIP="localhost";
	static String DBLink="jdbc:mysql://"+DBIP+":3306/";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return getConnectionFirst(rootName,rootPwd,DBName);
	}
	public static Connection getConnectionFirst(String rootName,String rootPwd,String DataBaseName ) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DBLink + DataBaseName 
					+ "?characterEncoding=utf-8&useSSL=false",
					rootName, rootPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeAll(Connection conn, PreparedStatement ps, ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
