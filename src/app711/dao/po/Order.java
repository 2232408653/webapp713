package app711.dao.po;

import java.util.Date;

public class Order {
	private int rid;
	private String user_id;
	private String order_id;
	private String sta;
	private int address_id;
	private String address_id1;
	public String getAddress_id1() {
		return address_id1;
	}
	public void setAddress_id1(String address_id1) {
		this.address_id1 = address_id1;
	}
	private double payment;
	private Date placed;
	private Date receipt;
	private Date deliver;
	private Date handover;
	private String product;
	private double price;
	private int count;
	private String title;
	private String press;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getSta() {
		return sta;
	}
	public void setSta(String sta) {
		this.sta = sta;
	}
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public double getPayment() {
		return payment;
	}
	public void setPayment(double payment) {
		this.payment = payment;
	}
	public Date getPlaced() {
		return placed;
	}
	public void setPlaced(Date placed) {
		this.placed = placed;
	}
	public Date getReceipt() {
		return receipt;
	}
	public void setReceipt(Date receipt) {
		this.receipt = receipt;
	}
	public Date getDeliver() {
		return deliver;
	}
	public void setDeliver(Date deliver) {
		this.deliver = deliver;
	}
	public Date getHandover() {
		return handover;
	}
	public void setHandover(Date handover) {
		this.handover = handover;
	}
}
