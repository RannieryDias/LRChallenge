package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.ProductForm;
import model.Receipt;
import model.ReceiptService;


class ReceiptTest{
	
	private ReceiptService service = new ReceiptService();
	
	@Test
	void testBooksFoodAndDrugsShouldNotBeTaxed() {
		List<ProductForm> products = this.getListOfExemptProducts();
		
		Receipt receipt = this.service.generateReceipt(products);
		
		assertEquals(0.0, receipt.getSaleTax());
		assertEquals(70.0, receipt.getTotal());
	}
	
	@Test
	void testNonExemptProductsShouldBeTaxedAt10Percent() {
		List<ProductForm> products = this.getListOfNonExemptProducts();
		
		Receipt receipt = this.service.generateReceipt(products);
		
		assertEquals(3.4, receipt.getSaleTax());
		assertEquals(37.4, receipt.getTotal());
	}
	
	@Test
	void testImportedProductsShouldBeTaxedAt5Percent() {
		List<ProductForm> products = this.getListImportedProducts();
		
		Receipt receipt = this.service.generateReceipt(products);
		
		assertEquals(7.65, receipt.getSaleTax());
		assertEquals(65.15, receipt.getTotal());
	}
	
	//Test 1 of each type of exempt products
	@Test
	private List<ProductForm> getListOfExemptProducts() {
		ProductForm book = new ProductForm("Cracking the code interview", 50.00, "book", 1, false);
		ProductForm medicine = new ProductForm("Headache pills", 9.15, "medicine", 2, false);
		ProductForm food = new ProductForm("Bar of chocolate", 0.85, "food", 2, false);
		
		List<ProductForm> products = new ArrayList<ProductForm>();
		
		products.add(book);
		products.add(medicine);
		products.add(food);
		
		return products;
	}
	
	//test products that is taxable but not imported
	@Test
	private List<ProductForm> getListOfNonExemptProducts() {
		ProductForm product1 = new ProductForm("A bottle of Perfume", 18.99, "perfumery", 1, false);
		ProductForm product2 = new ProductForm("A CD", 14.99, "electronics", 1, false);
		
		List<ProductForm> products = new ArrayList<ProductForm>();
		
		products.add(product1);
		products.add(product2);
		
		return products;
	}
	
	//test products that is imported
	@Test
	private List<ProductForm> getListImportedProducts() {
		ProductForm importedProduct1 = new ProductForm("Box of chocolat", 10.00, "food", 1, true);
		ProductForm importedProduct2 = new ProductForm("Perfume", 47.50, "perfumery", 1, true);
		
		List<ProductForm> products = new ArrayList<ProductForm>();
		
		products.add(importedProduct1);
		products.add(importedProduct2);
		
		return products;
	}
	
	
}
