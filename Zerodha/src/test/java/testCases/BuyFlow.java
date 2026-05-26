package testCases;

import org.testng.annotations.Test;

import pageObject.HomePage;
import testBase.BaseClass;

public class BuyFlow extends BaseClass{

	@Test(priority = 2)
	public void buyStock(){
		  logger.info("*****************************Buy Flow started******************************");

		HomePage hm= new HomePage(driver);
	  hm.hoverStock();
	  logger.info("Stock hovered successfully");
	  
	  hm.clickOnBuy();
	  logger.info("Clicked on the Buy button successfully");
	  logger.info("*****************************Buy Flow ended******************************");

	}

	
	
}
