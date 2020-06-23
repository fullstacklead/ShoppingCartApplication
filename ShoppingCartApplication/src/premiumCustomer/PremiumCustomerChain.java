package premiumCustomer;

import common.Amount;
import common.Constants;
import common.CustomerChain;
import common.DiscountChain;
import util.AmountValidation;

public class PremiumCustomerChain implements CustomerChain{
	
	private DiscountChain chain1;
	private AmountValidation amountValidation = new AmountValidation();
	
	public PremiumCustomerChain() {
		this.chain1 = new ThirtyPercentDiscountPC();
		DiscountChain chain2 = new TwentyPercentDiscPC();
		DiscountChain chain3 = new FifteenPercentPC();
		DiscountChain chain4 = new TenPercentDiscountPC();
		
		chain1.setNextChain(chain2);
		chain2.setNextChain(chain3);
		chain3.setNextChain(chain4);
		
	}
	

	@Override
	public void invokeDiscountChain(Amount amount) throws Exception {
		if(amountValidation.validateAmount(amount.getPurchaseAmount())) {
		
		PremiumCustomerChain premiumCustomerChain = new PremiumCustomerChain();
		premiumCustomerChain.chain1.discount(amount);
		
		double finalBill = amount.getPurchaseAmount() - amount.getEffectiveDiscount();
		
		System.out.println("Total discount is "+amount.getEffectiveDiscount());
		System.out.println("Effective amount to be paid is "+finalBill);
		}else {
			throw new Exception(Constants.INVALID_AMOUNT);
		}
	}

}
