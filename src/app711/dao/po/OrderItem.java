package app711.dao.po;

public class OrderItem {
	int rid;
	String product;
	Double price;
	int count;
	String order_id;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	
}
