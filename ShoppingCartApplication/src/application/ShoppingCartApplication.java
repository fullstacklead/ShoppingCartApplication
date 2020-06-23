package application;

import common.Amount;
import common.CustomerChain;
import common.CustomerChainFactory;

/**
* This class can act as a starting point of the application
* if we plan to trigger the flow from here
*
* @author  Anshul Dhoot
* @version 1.0
* @since   June 2020 
*/
public class ShoppingCartApplication {
	
	public static void main(String[] args) throws Exception {
		System.out.println("Starting shopping cart application ..");
		
		CustomerChainFactory customerChainFactory = new CustomerChainFactory();
		
		System.out.println("Fetching factory as per customer type");
		CustomerChain customerChain = customerChainFactory.getCustomerChain("Premium");
		customerChain.invokeDiscountChain(new Amount(15000));
		
	}

}
