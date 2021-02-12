package constant;

public enum NonTaxable {
	BOOK, FOOD, MEDICAL;

	public static boolean contains(String type) {

	    for (NonTaxable c : NonTaxable.values()) {
	        if (c.name().equals(type)) {
	            return true;
	        }
	    }
	    return false;
	}

}
