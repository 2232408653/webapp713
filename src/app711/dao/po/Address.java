package app711.dao.po;

import java.util.Date;

public class Address {
	private int rid;
	private String user;
	private String address;
	private Date added;
	private String receiver;
	private String receiverPhone;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getAdded() {
		return added;
	}
	public void setAdded(Date added) {
		this.added = added;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getReceiverPhone() {
		return receiverPhone;
	}
	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}
}
