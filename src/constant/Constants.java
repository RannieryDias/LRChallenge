package constant;

public class Constants {
	public static final double BASIC_SALES_TAX = 0.1;
	public static final double IMPORT_TAX = 0.05;
	public static final String IMPORTED_KEYWORD = "imported";
	
	public static final double round(double value) {
		return Math.round(value * 20.0) / 20.0;
	}
}
