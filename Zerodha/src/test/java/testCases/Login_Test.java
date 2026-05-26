package testCases;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class Login_Test extends BaseClass {
	
	public Properties p;
	
	@Test(priority = 1)
	public void login() throws IOException, InterruptedException {
		logger.info("***************Login Started******************");
	
			FileReader file= new FileReader(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			p= new Properties();
			p.load(file);
			
			LoginPage login= new LoginPage(driver);
			System.out.println(p.getProperty("userid"));
			login.setUserId(p.getProperty("userid"));
			logger.info("User id enter sucessfully");
			login.setPass(p.getProperty("password"));
			logger.info("Passwrod enter sucessfully");
			login.clickLogin();
			logger.info("Clicked on Login Button sucessfully");
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
			
			
			String actualURL="https://kite.zerodha.com/dashboard";
			Assert.assertTrue(driver.getCurrentUrl().contains(actualURL),"Login Failed");
			logger.info("OTP entered successfully");
			logger.info("Logged in successfully");
			
			HomePage hm= new HomePage(driver);
			hm.clickUnderstand();
			
			
			
			


		logger.info("*************** Login ended*******************");
		
		
	}
	
}
