package entities;

public class Product {
	private String name;
	private Double price; 
	private Integer qtt; 
	
	public Product() {
		
	}

	public Product(String name, double price, int qtt) {
		this.name = name;
		this.price = price;
		this.qtt = qtt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public int getQtt() {
		return qtt;
	}
	
	public double total() {
		return price*qtt;
	}
	
	
	
}
