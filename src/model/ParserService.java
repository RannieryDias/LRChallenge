package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import constant.NonTaxable;
import controller.Taxable;
import interfaces.IProducts;

public class ParserService {
	private Map<String, IProducts> products;
	
	public List<IProducts> parseProducts(List<ProductForm> forms) {
		return forms
				.stream()
				.map(form -> this.getProductFromForm(form))
				.collect(Collectors.toList());
	}
	
	private IProducts getProductFromForm(ProductForm form) {
		IProducts product = products.get(form.getCategory().toUpperCase());
		
		if (NonTaxable.contains(product.getCategory()) == false) {
			product = getDefaultProductService();
		}

		product.setPrice(form.getPrice());
		product.setName(form.getName());
		product.setAmount(form.getAmount());
		product.setCategory(form.getCategory());
		
		return product;
	}



	private IProducts getDefaultProductService() {
		return new Taxable();
	}
}
