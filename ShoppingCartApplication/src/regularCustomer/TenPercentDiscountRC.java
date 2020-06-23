package regularCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class TenPercentDiscountRC implements DiscountChain {
	
	private DiscountChain chain;

	@Override
	public void setNextChain(DiscountChain discountChain) {
		this.chain = discountChain;
	}

	@Override
	public void discount(Amount amount) {

		double reducedAmount = amount.getReducedAmount();
		if(reducedAmount >= Constants.FIVE_THOUSAND) {
			double tenPercentDiscount = (reducedAmount - Constants.FIVE_THOUSAND)* Constants.TEN_PERCENT;
			System.out.println("10% discount is "+tenPercentDiscount);
			amount.setEffectiveDiscount(amount.getEffectiveDiscount()+tenPercentDiscount);
			amount.setReducedAmount(Constants.FIVE_THOUSAND);
			this.chain.discount(amount);
		}else {
			this.chain.discount(amount);
		}	
		
	}

}
