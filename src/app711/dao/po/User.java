package app711.dao.po;

import java.util.Date;

/**
 * 一个对象（变量）表示数据库表中的一条记录
 * 类：用来描述数据库表的记录
 * 记录：持久存在（不因程序的运行状态而改变）
 * 类--->持久类(实体类)-->Persistent Object放在po包中
 * 类名参照表名（一般情况下持久类的类名不加po后缀）
 * 属性参照字段(名，类型)
 * 快速生成
 * @author Admini
 *
 */
public class User {
	
	private String password;
	private String phone;
	private String name;
	private String email;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public User(String name,String password,String email,String phone) {
		this.name=name;
		this.password=password;
		this.email=email;
		this.phone=phone;
	}
	
	public User() {
		name=null;
		password=null;
		phone=null;
		email=null;
	}

	
	
}
