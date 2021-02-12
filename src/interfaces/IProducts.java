package interfaces;

public interface IProducts {
	public IProducts applyTaxes();
	public double sumTaxes();
	
	public double getPrice();
	public void setPrice(double price);
	
	public String getName();
	public void setName(String name);
	
	public int getAmount();
	public void setAmount(int amount);
	
	public void setCategory(String category);
	public String getCategory();
	
	public double sumTotal();
}
