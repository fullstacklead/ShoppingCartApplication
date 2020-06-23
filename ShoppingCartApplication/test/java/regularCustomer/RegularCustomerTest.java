package regularCustomer;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import common.Amount;
import common.Constants;

@RunWith(MockitoJUnitRunner.class)
public class RegularCustomerTest {
	
	@InjectMocks
	private TwentyPercentDiscountRC twentyPercentDiscountRC ;
	
	private Amount amount;
	
	private RegularCustomerChain regularCustomerChain = new RegularCustomerChain();
	
	  @Before public void init() {
		  MockitoAnnotations.initMocks(this); 
		  TenPercentDiscountRC ten = new TenPercentDiscountRC();
			
			twentyPercentDiscountRC = new TwentyPercentDiscountRC();
			twentyPercentDiscountRC.setNextChain(ten);
		  }
	 

	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsMoreThanTenThousand() throws Exception {
		  amount = new Amount(15000);
		  try {
			  regularCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(1500, amount.getEffectiveDiscount(), 2);
		  assertEquals(13500, 15000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsLessThanTenThousand() throws Exception {
		  amount = new Amount(5000);
		  try {
			  regularCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(0, amount.getEffectiveDiscount(), 2);
		  assertEquals(5000, 5000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsEqualToTenThousand() throws Exception {
		
		  amount = new Amount(10000);
		  try {
			  regularCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(500, amount.getEffectiveDiscount(), 2);
		  assertEquals(9500, 10000 - amount.getEffectiveDiscount(), 2);
	}
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsNegative() throws Exception {
		  amount = new Amount(-10);
		  try {
			  regularCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
			  assertEquals(new StringBuilder(Constants.INVALID_AMOUNT).toString(), new StringBuilder(r.getMessage()).toString());
		  }
	}
	
	
	@Test
	public void testDiscountAndEffectiveAmountWhenValueIsZero() throws Exception {
		
		  amount = new Amount(0);
		  try {
			  regularCustomerChain.invokeDiscountChain(amount);
		  }catch (Exception r){
		  }
		  assertEquals(0, amount.getEffectiveDiscount(), 2);
	}
	
}
