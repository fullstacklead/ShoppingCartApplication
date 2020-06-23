#package applicaion 
Class ShoppingCartApplication - This could act as a starting point if we want to execute main method.

#package common
Interface CustomerChain - RegularCustomerChain and PremiumCustomerChain classes will implement this interface.
Class CustomerChainFactory - This factory will give object of regular or premium customer chain depending on type of customer.
Enum CustomerType - This enum has contants for customer type.
Interface DiscountChain - This interface will be implemented by all discount chains of regular and premium customer. This has
methods by which we can chain the responsibilities to next discount class.


Test Classes :
CustomerChainFactoryTest - This has all the use cases listed in the problem statements and negative test cases as well.
PremiumCustomerTest - This has test cases specific to premium customer
RegularCustomerTest - This has test cases specific to regular customer