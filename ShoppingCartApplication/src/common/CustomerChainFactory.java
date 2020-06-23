package common;

import premiumCustomer.PremiumCustomerChain;
import regularCustomer.RegularCustomerChain;

public class CustomerChainFactory {
	
	public CustomerChain getCustomerChain(String customerType) throws Exception {
		if(customerType.equals(CustomerType.REGULAR.getCustomerType())) {
			System.out.println("Customer type : Regular");
			return new RegularCustomerChain();
		}
		if(customerType.equals(CustomerType.PREMIUM.getCustomerType())) {
			System.out.println("Customer type : Premium");
			return new PremiumCustomerChain();
		}
		else {
			throw new Exception(Constants.INVALID_CUSTOMERTYPE_MSG);
		}
		
	}

}
