package common;

public interface DiscountChain {
	
	public void setNextChain(DiscountChain discountChain);
	public void discount(Amount amount);

}
