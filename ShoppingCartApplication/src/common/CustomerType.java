package common;

public enum CustomerType {
	
	REGULAR("Regular"),
	PREMIUM("Premium");

	private String customerType;
	
	private CustomerType(String string) {
		customerType = string;
	}
	
	public String getCustomerType() {
		return customerType;
	}

}
