package common;

public interface CustomerChain {
	
	public void invokeDiscountChain(Amount amount) throws Exception;

}
