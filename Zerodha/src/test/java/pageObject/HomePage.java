package pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement btnIUnderstand;
	
	@FindBy(xpath = "//span[text()='COALINDIA']")
	WebElement stock;
	
	@FindBy(css = ".button-blue.buy")
	WebElement btnBuy;

	public void clickUnderstand() {
		btnIUnderstand.click();
	}
	
	public void hoverStock() {
		Actions act = new Actions(driver);	
		act.moveToElement(stock).perform();
	}
	
	public void clickOnBuy() {
		btnBuy.click();
	}

}
