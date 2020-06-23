package regularCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class TwentyPercentDiscountRC implements DiscountChain{
	
	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
	}

	@Override
	public void discount(Amount amount) {
		double purchaseAmount = amount.getPurchaseAmount();
		if(purchaseAmount >= Constants.TEN_THOUSAND) {
			double discount = (purchaseAmount - Constants.TEN_THOUSAND)* Constants.TWENTY_PERCENT;
			System.out.println("20% discount is "+discount);
			amount.setEffectiveDiscount(discount);
			amount.setReducedAmount(Constants.TEN_THOUSAND);
			this.chain.discount(amount);
		}else {
			amount.setReducedAmount(purchaseAmount);
			this.chain.discount(amount);
		}
	}

}
