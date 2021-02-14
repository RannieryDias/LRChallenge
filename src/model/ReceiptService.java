package model;

import java.util.List;
import java.util.stream.Collectors;

import constant.Constants;
import interfaces.Product;

public class ReceiptService {
	
	private ParserService parser = new ParserService();
	
	//Method that generate the receipt from a list of products
	public Receipt generateReceipt(List<ProductForm> forms) {
		List<Product> products = this.parser.parseProducts(forms);

		double taxesPaid = this.getTotalProductTaxes(products);
		
		products = this.applyTaxes(products);
		
		double totalPrice = this.getTotal(products);
	
		return new Receipt(taxesPaid, totalPrice, products);
	}
	
	private double getTotalProductTaxes(List<Product> products) {		
		double total = products
				/*converte tipo stream*/.stream()
				/*mapeia uma coleção em outra*/.mapToDouble(product -> product.sumTaxes())
				/*soma o resultado*/.sum();
		
		return Constants.round(total);
	}
	
	private List<Product> applyTaxes(List<Product> products) {
		return products
				.stream()
				.map(product -> product.applyTaxes())
				.collect(Collectors.toList());
	}
	
	private double getTotal(List<Product> products) {
		double total = products
				.stream()
				.mapToDouble(product -> product.sumTotal())
				.sum();
		
		return Constants.round(total);
	}
}
