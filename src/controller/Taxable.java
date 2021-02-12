package controller;

import constant.Constants;
import interfaces.IProducts;

public class Taxable implements IProducts {

	private double price;
	private String name;
	private String category;
	private int amount;
	
	@Override
	public IProducts applyTaxes() {
		double total = this.getPrice() + this.sumTaxes();
		
		this.setPrice(total);

		return this;
	}
	
	@Override
	public double sumTaxes() {
		double taxesSum = this.calculateBasicTax() + this.calculateImportTax();
		
		return Constants.round(taxesSum);
	}
	
	private double calculateBasicTax() {
		return this.getPrice() * Constants.BASIC_SALES_TAX;
	}
	
	private double calculateImportTax() {
		if (this.isImported()) {
			return this.getPrice() * Constants.IMPORT_TAX;			
		}
		
		return 0.0;
	}
	
	public boolean isImported() {
		return this.getName().contains(Constants.IMPORTED_KEYWORD);
	}
	
	public double sumTotal() {
		return this.getPrice() * this.getAmount();
	}

	//verify if value is 0 or less returning 1 if false and 0 if true
	public int verifyValue(int value) {
		if (value <= 0) {
			return 0;
		}else{
			return 1;
		}
	}
	
	//getters and setters from the abstract interface class
	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public void setPrice(double price) {
		//TODO SET EXCEPTION
		if(price <= 0) {}
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		
		this.name = name;
	}
	
	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public void setCategory(String category) {
		//TODO SET EXCEPTION
		if (category == null) {}
		else {
			this.category = category;
		}
	}

	@Override
	public int getAmount() {
		return amount;
	}
	
	@Override
	public void setAmount(int amount) {
		
		int validate = verifyValue(amount);
		//TODO SET EXCEPTION
		this.amount = amount;
	}

}
