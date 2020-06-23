package common;

/**
* This is a domain object which has detail about
* purchase amount and effective discount
*
* @author  Anshul Dhoot
* @version 1.0
* @since   June 2020 
*/

public class Amount {
	
	private double purchaseAmount;
	private double effectiveDiscount;
	private double reducedAmount;
	
	public Amount(double i) { this.purchaseAmount = i; }
	
    public double getReducedAmount() {
		return reducedAmount;
	}

	public void setReducedAmount(double reducedAmount) {
		this.reducedAmount = reducedAmount;
	}
	
	public double getEffectiveDiscount() {
		return effectiveDiscount;
	}

	public void setEffectiveDiscount(double effectiveDiscount) {
		this.effectiveDiscount = effectiveDiscount;
	}

	public double getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(double remainingPurchaseAmount) {
		this.purchaseAmount = remainingPurchaseAmount;
	}

}
