package app711.dao.po;

public class CartItem {
	private int rid;
	private String isbn;
	private String author;
	private String title;
	private Double price;
	private String user_id;
	private int count;
    private String product;
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
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
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getCount(){
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
