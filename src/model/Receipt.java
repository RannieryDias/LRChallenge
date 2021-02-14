package model;

import java.util.List;

import interfaces.Product;

public class Receipt {
	private double saleTax;
	private double total;
	private List<Product> products;
	
	//constructor
	public Receipt(double tax, double total, List<Product> products) {
		this.saleTax = tax;
		this.total = total;
		this.products = products;
		
	}

	//getters and setters
	public double getSaleTax() {
		return saleTax;
	}

	public void setSaleTax(double tax) {
		this.saleTax = tax;
	}

	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		//TODO SE EXCEPTION
		if(total <= 0) {
			
		}else {
			this.total = total;
		}
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
