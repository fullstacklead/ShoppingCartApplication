package premiumCustomer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import common.Amount;
import common.Constants;


@RunWith(MockitoJUnitRunner.class)
public class PremiumCustomerTest {
	
	private ThirtyPercentDiscountPC thirty = new ThirtyPercentDiscountPC();
	private Amount amount;
	private PremiumCustomerChain premiumCustomerChain = new PremiumCustomerChain();
	
	@Before public void init() {
		  MockitoAnnotations.initMocks(this); 
		  TwentyPercentDiscPC twenty = new TwentyPercentDiscPC();
		  FifteenPercentPC fifteen = new FifteenPercentPC();
		  TenPercentDiscountPC ten = new TenPercentDiscountPC();
			
			thirty.setNextChain(twenty);
			twenty.setNextChain(fifteen);
			fifteen.setNextChain(ten);
		  }
	
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsMoreThanTelveThousand() throws Exception {
		  amount = new Amount(20000);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(4200, amount.getEffectiveDiscount(), 2);
		  assertEquals(15800, 20000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsMoreThanEightThousand() throws Exception {
		  amount = new Amount(8000);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(1000, amount.getEffectiveDiscount(), 2);
		  assertEquals(7000, 8000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsMoreThanFourThousand() throws Exception {
		  amount = new Amount(4000);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(400, amount.getEffectiveDiscount(), 2);
		  assertEquals(3600, 4000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsLessThanFourThousand() throws Exception {
		  amount = new Amount(20);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(2, amount.getEffectiveDiscount(), 2);
		  assertEquals(18, 20 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsZero() throws Exception {
		  amount = new Amount(0);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(0, amount.getEffectiveDiscount(), 2);
		  assertEquals(0, 0 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsLessThanZero() throws Exception {
		  amount = new Amount(-10);
		  try {
			  premiumCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
			  assertEquals(new StringBuilder(Constants.INVALID_AMOUNT).toString(), new StringBuilder(r.getMessage()).toString());
		  }
		  
	}

}
