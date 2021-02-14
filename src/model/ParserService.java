package model;

import java.util.List;
import java.util.stream.Collectors;

import constant.NonTaxable;
import controller.ExemptProduct;
import controller.Taxable;
import interfaces.Product;

public class ParserService {

	public List<Product> parseProducts(List<ProductForm> forms) {
		return forms.stream().map(form -> this.getProductFromForm(form)).collect(Collectors.toList());
	}

	private Product getProductFromForm(ProductForm form) {
		Product product = getProductInstance(form.getCategory().toUpperCase());

		product.setPrice(form.getPrice());
		product.setName(form.getName());
		product.setAmount(form.getAmount());
		product.setCategory(form.getCategory());
		product.setIsImported(form.getIsImported());

		return product;
	}

	private Product getProductInstance(String category) {
		Product product;
		System.out.println(category);
		if (NonTaxable.contains(category)) {
			System.out.println("Instanciou isento");
			product = new ExemptProduct();
		} else {
			product = new Taxable();
		}

		return product;
	}
}
