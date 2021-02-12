	package controller;

import constant.Constants;
import interfaces.IProducts;

public abstract class ExemptProductService implements IProducts {

	private double price;
	private String name;
	private String category;
	private int amount;

	public boolean isImported() {
		return this.getName().contains(Constants.IMPORTED_KEYWORD);
	}
	
	public double sumTotal() {
		return this.getPrice() * this.getAmount();
	}
	
	public double sumTaxes() {
		if (this.isImported()) {
			return Constants.round(this.getPrice() * Constants.IMPORT_TAX);
		}
		
		return 0.0;
	}
	
	
	public IProducts applyTaxes() {
		double total = this.getPrice() + this.sumTaxes();
		this.setPrice(total);
		
		return this;
	}

}
