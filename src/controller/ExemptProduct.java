package controller;

import constant.Constants;
import interfaces.Product;

public class ExemptProduct implements Product {

	private double price;
	private String name;
	private String category;
	private int amount;
	private boolean isImported;
	
	public boolean isImported() {
		return this.isImported;
	}

	public double sumTotal() {
		//return this.getPrice() * this.getAmount();
		
		double total = this.getPrice() * this.getAmount();
		System.out.println("total = " + total);
		return total;
	}

	public double sumTaxes() {
		if (this.isImported()) {
			return Constants.round(this.getPrice() * Constants.IMPORT_TAX);
		}else {
		return 0.0;
		}
	}

	public Product applyTaxes() {
		double total = this.getPrice() + this.sumTaxes();
		this.setPrice(total);
		
		return this;
	}

	// getters and setters

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public void setIsImported(boolean isImported) {
		this.isImported = isImported;
	}

	@Override
	public boolean getIsImported() {
		return isImported;
	}

}
