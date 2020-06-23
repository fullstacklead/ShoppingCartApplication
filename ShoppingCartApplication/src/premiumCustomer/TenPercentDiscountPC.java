package premiumCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class TenPercentDiscountPC implements DiscountChain {
	
	DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
	}

	@Override
	public void discount(Amount amount) {
		double reducedAmount = amount.getReducedAmount();
		if(reducedAmount <= Constants.FOUR_THOUSAND) {
			double tenPercentDiscount = reducedAmount * Constants.TEN_PERCENT;
			System.out.println("10% discount is "+tenPercentDiscount);
			amount.setEffectiveDiscount(amount.getEffectiveDiscount()+tenPercentDiscount);
		}else {
			amount.setEffectiveDiscount(amount.getEffectiveDiscount()+ amount.getPurchaseAmount()* Constants.TEN_PERCENT);
		}	
		
	
	}

}
