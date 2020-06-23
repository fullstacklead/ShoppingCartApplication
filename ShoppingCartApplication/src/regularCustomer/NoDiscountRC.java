package regularCustomer;

import common.Amount;
import common.Constants;
import common.DiscountChain;

public class NoDiscountRC implements DiscountChain {
	
	@Override
	public void setNextChain(DiscountChain discountChain) {
	}

	@Override
	public void discount(Amount amount) {
		if(amount.getPurchaseAmount() <= Constants.FIVE_THOUSAND || amount.getReducedAmount() <= Constants.FIVE_THOUSAND) {
			System.out.println("Amount is less than 5000. No discount");
		}
		
	}
}
