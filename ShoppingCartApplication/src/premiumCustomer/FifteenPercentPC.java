package premiumCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class FifteenPercentPC implements DiscountChain {
	
	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
	}

	@Override
	public void discount(Amount amount) {
		double reducedAmount = amount.getReducedAmount();
		if(reducedAmount >= Constants.FOUR_THOUSAND) {
			double fifteenPercentDiscount = (reducedAmount - Constants.FOUR_THOUSAND)* Constants.FIFTEEN_PERCENT;
			System.out.println("15% discount is "+fifteenPercentDiscount);
			amount.setEffectiveDiscount(amount.getEffectiveDiscount()+fifteenPercentDiscount);
			amount.setReducedAmount(Constants.FOUR_THOUSAND);
			this.chain.discount(amount);
		}else {
			amount.setReducedAmount(amount.getPurchaseAmount());
			this.chain.discount(amount);
		}	
		
	}

}
