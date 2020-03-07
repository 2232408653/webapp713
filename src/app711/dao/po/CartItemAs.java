package app711.dao.po;

public class CartItemAs {
	   private String  press; 
	   
		private String product;
	       private String user_id;
	       private int count;
	       private double price;
	       private String author;
	       private String  title;
	       private  int rid;
	       public String getPress() {
	   		return press;
	   	}
	   	public void setPress(String press) {
	   		this.press = press;
	   	}
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
		public String getUser_id() {
			return user_id;
		}
		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double d) {
			this.price = d;
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
}
