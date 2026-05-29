package pageObject;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class BuyFlow extends BasePage {

	public BuyFlow(WebDriver driver) {
		super(driver);
	}
	Logger logger = BaseClass.logger;
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	@FindBy(xpath = "//input[@icon='search']")
	WebElement searchBar;
	
	@FindBy(css = ".name")
	WebElement stock;
	
	@FindBy(css = ".button-blue")
	WebElement btnBuy;
	
	@FindBy(xpath = "//label[text()='Regular']")
	WebElement lblRegular;
	
	@FindBy(xpath = "//div[contains(@class,'type four columns su-radio-wrap checked')]")
	WebElement rbtnLongterm;
	
	@FindBy(xpath  = "//input[@label='Qty.']")
	WebElement ipQuantity;
	
	@FindBy(xpath  = "//input[@label='Price']")
	WebElement ipPrice;
	
	@FindBy(xpath  = "//input[contains(@label,'Trigger price')]")
	WebElement ipTriggerPrice;
	
	@FindBy(xpath = "//label[contains(text(),'Market')]")
	WebElement rbtnMarket;
	
	@FindBy(xpath = "//label[contains(text(),'Limit')]")
	WebElement rbtnLimit;
	
	@FindBy(xpath = "//label[contains(text(),'SL')]")
	WebElement rbtnSL;
	
	@FindBy(xpath = "//label[contains(text(),'SL-M')]")
	WebElement rbtnSLM;
	
	@FindBy(xpath = "//div[@class='order-window-wrapper']//span[contains(text(),'Advanced')]")
	WebElement ddAdvancedOptions;
	
	@FindBy(xpath = "//label[contains(text(),'Day')]")
	WebElement rbtnDay;
	
	@FindBy(xpath = "//label[contains(text(),'Immediate')]")
	WebElement rbtnImmediate;
	
	@FindBy(css = ".submit")
	WebElement btnBuyStock;
	
	@FindBy(xpath = "//div[contains(@class,'su-toast-item')]//div[@class='message']")
    WebElement successToastMessage;
	
	@FindBy(xpath = "//div[contains(@class,'su-toast-item')]//span[contains(@class,'close')]")
	WebElement iconCross;
	
	@FindBy(xpath = "//button[contains(@class,'button-outline button-transparent cancel')]")
	WebElement btnCancel;
	
	@FindBy(xpath ="//div[@class='su-checkbox-group']")
	WebElement chkStoploss;
	
	@FindBy(xpath ="(//div[@class='su-checkbox-group'])[2]")
	WebElement chkTarget;
	
	@FindBy(xpath = "//h4[@class='title']")
	List<WebElement> errorMessage;
	
	public void searchStock(String stock) {
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys(stock);
		logger.info("Searched stock successfully");

	}
	
	public void hoverStock() {
		wait.until(ExpectedConditions.visibilityOf(stock));
		Actions act = new Actions(driver);	
		act.moveToElement(stock).perform();
	    logger.info("Stock hovered successfully");
	}
	
	public void clickOnBuy() {
		wait.until(ExpectedConditions.visibilityOf(btnBuy));
		btnBuy.click();
		logger.info("Clicked on the Buy button successfully");

	}
	
	public void navigateToRegular() {
		wait.until(ExpectedConditions.visibilityOf(lblRegular));
		lblRegular.click();
		logger.info("Navigated to Regular successfully");

	}
	
	public void selectLongterm() {
		wait.until(ExpectedConditions.elementToBeClickable(rbtnLongterm));
		rbtnLongterm.click();
		logger.info("Longterm selected successfully");

	}

	public void setQuantity(String qty) {
		wait.until(ExpectedConditions.visibilityOf(ipQuantity));
		ipQuantity.sendKeys(qty);
		logger.info("Quantity set successfully");

	}
	
	public void setPrice(String price) {
		wait.until(ExpectedConditions.visibilityOf(ipPrice));
		ipPrice.sendKeys(price);
		logger.info("Price set successfully");
	}
	
	public void clearPrice() {
		wait.until(ExpectedConditions.visibilityOf(ipPrice));
		Actions act= new Actions(driver);
		act.click(ipPrice).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		logger.info("Price cleared successfully");
	}
	
	public void setTriggerPrice(String price){
		wait.until(ExpectedConditions.visibilityOf(ipTriggerPrice));
		ipTriggerPrice.sendKeys(price);
		logger.info("Trigger price set successfully");
	}
	
	public void clearTriggerPrice() {
		wait.until(ExpectedConditions.visibilityOf(ipTriggerPrice));
		Actions act= new Actions(driver);
		act.click(ipTriggerPrice).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
		logger.info("Price cleared successfully");
	}
	
	public void selectMarket() {
		wait.until(ExpectedConditions.visibilityOf(rbtnMarket));
		rbtnMarket.click();
		logger.info("Market option selected successfully");

	}
	
	public void selectLimit() {
		wait.until(ExpectedConditions.visibilityOf(rbtnLimit));
		rbtnLimit.click();
		logger.info("Limit option selected successfully");

	}
	
	public void selectSL() {
		wait.until(ExpectedConditions.visibilityOf(rbtnSL));
		rbtnSL.click();
		logger.info("SL option selected successfully");

	}
	
	public void selectSLM() {
		wait.until(ExpectedConditions.visibilityOf(rbtnSLM));
		rbtnSLM.click();
		logger.info("SLM option selected successfully");

	}
	
	public void clickAdvancedOptions() {
		wait.until(ExpectedConditions.visibilityOf(ddAdvancedOptions));
        try {
            String tooltipValue = ddAdvancedOptions.getAttribute("data-tooltip-content");
            if ("Show advanced options".equalsIgnoreCase(tooltipValue)) {
                logger.info("Advanced options are hidden. Clicking to show them.");
                ddAdvancedOptions.click();
          	  logger.info("Clicked on Advanced options successfully");

            } else {
                logger.info("Advanced options are already visible. No action needed.");
            }
        } catch (Exception e) {
            logger.error("Error while handling advanced options", e);
            Assert.fail("clickAdvancedOptionsIfHidden failed: " + e.getMessage());
        }
    }
	public void selectDay() {
		wait.until(ExpectedConditions.visibilityOf(rbtnDay));
		rbtnDay.click();
		  logger.info("Day selected successfully");

	}
	
	public void selectImmediate() {
		wait.until(ExpectedConditions.visibilityOf(rbtnImmediate));
		rbtnImmediate.click();
		  logger.info("Immediate selected successfully");

	}
	
	public void buyStock() {
		wait.until(ExpectedConditions.visibilityOf(btnBuyStock));
		btnBuyStock.click();
		  logger.info("Buy stock button clicked successfully");

	}
	
	public void clickOnCross() {
		
		if(iconCross!=null) {
			WebElement iconCross=driver.findElement(By.xpath("//div[contains(@class,'su-toast-item')]//span[contains(@class,'close')]"));
		wait.until(ExpectedConditions.visibilityOf(iconCross));
		iconCross.click();
		  logger.info("Clicked on cross successfully");
		}
	}
	
	public void clickCancel() {
		WebElement btnCancel=driver.findElement(By.xpath("//button[contains(@class,'button-outline button-transparent cancel')]"));
		if(btnCancel!=null) {
		wait.until(ExpectedConditions.visibilityOf(btnCancel));
		btnCancel.click();
		  logger.info("Clicked on the cancel button successfully");
		}
	}
	
	public void checkStoploss() {
		wait.until(ExpectedConditions.visibilityOf(chkStoploss));
		chkStoploss.click();
		  logger.info("Stoploss checked successfully");

	}
	
	public void checkTarget() {
		wait.until(ExpectedConditions.visibilityOf(chkTarget));
		chkTarget.click();
		  logger.info("Target checked successfully");

	}
	
	public void verifyToastMessage() {
	//	wait.until(ExpectedConditions.visibilityOf(successToastMessage));
		String toastMessage=successToastMessage.getText();
		boolean orderProcessed=toastMessage.contains("Insufficient funds") || toastMessage.contains("Markets are closed right now.")
				|| toastMessage.contains("next market opening") || toastMessage.contains("GTT orders are blocked for AMO orders") || toastMessage.contains("Trigger price for stoploss buy");
		Assert.assertTrue(orderProcessed, "Order not placed");
		 logger.info("Toast message verified successfully");

	}
	
	public void invalidQuantity_Price() {
	         
	         boolean doesAccept= (errorMessage.size() > 0 && errorMessage.get(0).isDisplayed());
	         Assert.assertFalse(doesAccept,"Test case failed invalid value is accpeted");
		    	logger.info("Test case passed invalid value is not accepted");
	         
	}

	public void validQuantity_Price() {
        
        boolean doesAccept= errorMessage.size() > 0 && errorMessage.get(0).isDisplayed();
        Assert.assertTrue(doesAccept,"Test case failed valid value is accpeted");
    	logger.info("Test case passed valid value is accepted");
        
}
	
	public void verifyPriceMoreThanCircuit() {
		boolean toastMessage=errorMessage.get(0).isDisplayed();
		Assert.assertTrue(toastMessage,"Test case failed price more than upper circuit is accepted");
		logger.info("Test case passed- "+successToastMessage.getText());
	}
}









