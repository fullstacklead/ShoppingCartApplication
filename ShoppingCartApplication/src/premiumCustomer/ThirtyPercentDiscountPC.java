package premiumCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class ThirtyPercentDiscountPC implements DiscountChain {
	
	DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
		
	}

	@Override
	public void discount(Amount amount) {
		double purchaseAmount = amount.getPurchaseAmount();
		if(purchaseAmount >= Constants.TWELVE_THOUSAND) {
			double discount = (purchaseAmount - Constants.TWELVE_THOUSAND)* Constants.THIRTY_PERCENT;
			System.out.println("30% discount is "+discount);
			amount.setEffectiveDiscount(discount);
			amount.setReducedAmount(Constants.TWELVE_THOUSAND);
			this.chain.discount(amount);
		}else {
			amount.setReducedAmount(amount.getPurchaseAmount());
			this.chain.discount(amount);
		}
	}

}
