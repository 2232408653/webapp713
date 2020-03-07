package app711.dao.po;

import java.util.Date;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private double price;
	private String press;
	private int edition;
	private Date published;
	private int pages;
	private int words;
	private String packaging;
	private String format;
	private String form;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition) {
		this.edition = edition;
	}
	public Date getPublished() {
		return published;
	}
	public void setPublished(Date published) {
		this.published = published;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getWords() {
		return words;
	}
	public void setWords(int words) {
		this.words = words;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	
}
