package model;

public class ProductForm {
	private String name;
	private String category;
	private double price;
	private int amount;
	boolean isImported;
	
	
	public ProductForm(String name, double price, String category, int amount, boolean isImported) {
		this.name = name;
		this.price = price;
		this.category = category;
		this.amount = amount;
		this.isImported = isImported;
	}


	//getters and stters
	//TODO Validar entradas
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public boolean getIsImported() {
		return isImported;
	}


	public void setIsImported(boolean isImported) {
		this.isImported = isImported;
	}
	
}
