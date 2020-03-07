package app711.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app711.dao.po.Book;
import app711.dao.po.User;
import app712.util.DBUtil;

public class BookDao {
	public ArrayList<Book> selectBookAll() throws SQLException {
		ArrayList<Book> books=new  ArrayList<Book>();
		
		Book book=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try {
			con=DBUtil.getConnection();
			String sql="select author,title,price,press,isbn,edition,published,pages,"
					+ "words,packaging,format from tb_book";
			sta=con.prepareStatement(sql);
			
			//if(sta.setString()
			sta.executeQuery();
			res=sta.executeQuery();
			while(res.next()) {
				book=new Book();
				book.setAuthor(res.getString("author"));
				book.setIsbn(res.getString("isbn"));
				book.setTitle(res.getString("title"));
				book.setPrice(res.getDouble("price"));
				book.setPress(res.getString("press"));
				book.setEdition(res.getInt("edition"));
				book.setPublished(res.getTimestamp("published"));
				book.setPages(res.getInt("pages"));
				book.setWords(res.getInt("words"));
				book.setPackaging(res.getString("packaging"));
				book.setFormat(res.getString("format"));
				//users[index]=user 通过程序控制索引
				books.add(book);
			}
			//System.out.println("影响了"+rows+"行");
			
		} finally {
			
				DBUtil.closeAll(con, sta, res);
		}
		return books;
	}
	
	public Book selectByIsbn(String isbn) throws SQLException {
		Book book=null;
		Connection con=null;
		PreparedStatement sta=null;
		ResultSet res=null;
		try {
			con=DBUtil.getConnection();
			String sql="select * from tb_book where isbn=?";
			sta=con.prepareStatement(sql);
			sta.setString(1,isbn);
			//if(sta.setString()
			sta.executeQuery();
			res=sta.executeQuery();
			while(res.next()) {
				book=new Book();
				book.setAuthor(res.getString("author"));
				book.setIsbn(res.getString("isbn"));
				book.setTitle(res.getString("title"));
				book.setPrice(res.getDouble("price"));
				book.setPress(res.getString("press"));
				book.setEdition(res.getInt("edition"));
				book.setPublished(res.getTimestamp("published"));
				book.setPages(res.getInt("pages"));
				book.setWords(res.getInt("words"));
				book.setPackaging(res.getString("packaging"));
				book.setFormat(res.getString("format"));
				
				//users[index]=user 通过程序控制索引
			}
			//System.out.println("影响了"+rows+"行");
			
		} finally {
			
				DBUtil.closeAll(con, sta, res);
		}
		return book;
	}
}
