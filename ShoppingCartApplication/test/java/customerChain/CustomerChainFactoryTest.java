package customerChain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import common.Amount;
import common.Constants;
import common.CustomerChain;
import common.CustomerChainFactory;
import premiumCustomer.PremiumCustomerChain;
import regularCustomer.RegularCustomerChain;

@RunWith(MockitoJUnitRunner.class)
public class CustomerChainFactoryTest {
	
	CustomerChainFactory customerChainFactory = new CustomerChainFactory();
	
	@Test
	public void checkIfRegularCustomerFactoryReturned() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		
	}
	
	@Test
	public void RegularCustomerUseCase1() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		Amount amount = new Amount(5000);
		customerChain.invokeDiscountChain(amount);
		//Verify Discount
		assertEquals(0, amount.getEffectiveDiscount(), 2);
		//Verify Final bill
		assertEquals(5000, 5000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void RegularCustomerUseCase2() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		Amount amount = new Amount(10000);
		customerChain.invokeDiscountChain(amount);
		//Verify Discount
		assertEquals(500, amount.getEffectiveDiscount(), 2);
		//Verify Final bill
		assertEquals(9500, 10000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void RegularCustomerUseCase3() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		Amount amount = new Amount(15000);
		customerChain.invokeDiscountChain(amount);
		//Verify Discount
		assertEquals(1500, amount.getEffectiveDiscount(), 2);
		//Verify Final bill
		assertEquals(13500, 15000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void RegularCustomerAmountNegative() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		Amount amount = new Amount(-10);
		try {
		customerChain.invokeDiscountChain(amount);
		}
		catch (Exception r){
			  assertEquals(new StringBuilder(Constants.INVALID_AMOUNT).toString(), new StringBuilder(r.getMessage()).toString());
		  }
	}
	
	@Test
	public void RegularCustomerAmountZero() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.REGULAR);
		assertTrue(customerChain instanceof RegularCustomerChain);
		Amount amount = new Amount(0);
		customerChain.invokeDiscountChain(amount);
		//Verify Discount
	    assertEquals(0, amount.getEffectiveDiscount(), 2);
	    //Verify Final bill
	  	assertEquals(0, 0 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void checkIfPremiumFactoryReturned() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
		assertTrue(customerChain instanceof PremiumCustomerChain);
	}
	
	@Test
	public void PremiumCustomerUseCase1() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
		assertTrue(customerChain instanceof PremiumCustomerChain);
		 Amount amount = new Amount(20000);
		 customerChain.invokeDiscountChain(amount);
		  assertEquals(4200, amount.getEffectiveDiscount(), 2);
		  assertEquals(15800, 20000 - amount.getEffectiveDiscount(), 2);
		
	}
	
	@Test
	public void PremiumCustomerUseCase2() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
		assertTrue(customerChain instanceof PremiumCustomerChain);
		 Amount amount = new Amount(8000);
		 customerChain.invokeDiscountChain(amount);
		  assertEquals(1000, amount.getEffectiveDiscount(), 2);
		  assertEquals(7000, 8000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void PremiumCustomerUseCase3() throws Exception {
		CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
		assertTrue(customerChain instanceof PremiumCustomerChain);
		 Amount amount = new Amount(4000);
		 customerChain.invokeDiscountChain(amount);
		  assertEquals(400, amount.getEffectiveDiscount(), 2);
		  assertEquals(3600, 4000 - amount.getEffectiveDiscount(), 2);
	}
	
	
	  @Test 
	  public void PremiumCustomerUseCase4() throws Exception { 

			CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
			assertTrue(customerChain instanceof PremiumCustomerChain);
			 Amount amount = new Amount(12000);
			 customerChain.invokeDiscountChain(amount);
			 assertEquals(1800, amount.getEffectiveDiscount(), 2);
			 assertEquals(10200, 12000 - amount.getEffectiveDiscount(), 2);
		
		 }
	 
	  
	  @Test
	  public void PremiumCustomerNegativeAmount() throws Exception {

			CustomerChain customerChain = customerChainFactory.getCustomerChain(Constants.PREMIUM);
			assertTrue(customerChain instanceof PremiumCustomerChain);
			Amount amount = new Amount(-10);
			try {
			customerChain.invokeDiscountChain(amount);
			}
			catch (Exception r){
				  assertEquals(new StringBuilder(Constants.INVALID_AMOUNT).toString(), new StringBuilder(r.getMessage()).toString());
			  }
		
		  
	  }
	  
	 @Test
	 public void InvalidCustomerType() throws Exception {
		 try {
		 customerChainFactory.getCustomerChain(Constants.INVALID_CUSTOMERTYPE);
		 }catch(Exception e) {
			 assertTrue(Constants.INVALID_CUSTOMERTYPE_MSG.equals(e.getMessage()));
		 }
		 
	 }
	

}
