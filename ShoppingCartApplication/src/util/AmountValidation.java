package util;

public class AmountValidation {
	
	public boolean validateAmount(double purchaseAmount) {
		if(purchaseAmount < 0) {
			return false;
		}else {
			return true;
		}
	}

}
