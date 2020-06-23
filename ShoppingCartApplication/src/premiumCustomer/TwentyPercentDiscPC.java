package premiumCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class TwentyPercentDiscPC implements DiscountChain{
	
	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
	}

	@Override
	public void discount(Amount amount) {
		double reducedAmount = amount.getReducedAmount();
		if(reducedAmount >= Constants.EIGHT_THOUSAND) {
			double twentyPercentDiscount = (reducedAmount - Constants.EIGHT_THOUSAND)* Constants.TWENTY_PERCENT;
			System.out.println("20% discount is "+twentyPercentDiscount);
			amount.setEffectiveDiscount(amount.getEffectiveDiscount()+twentyPercentDiscount);
			amount.setReducedAmount(Constants.EIGHT_THOUSAND);
			this.chain.discount(amount);
		}else {
			amount.setReducedAmount(amount.getPurchaseAmount());
			this.chain.discount(amount);
		}	
		
	
	}

}
