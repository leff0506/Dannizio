package parser;

public class Pizza {
	private String title;
	private String size;
	private String decription;
	private boolean available;
	private int id;
	private double price;
	public Pizza(String title, String size, String decription, boolean available, int id,double price) {
		super();
		this.title = title;
		this.size = size;
		this.decription = decription;
		this.available = available;
		this.id = id;
		this.setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
