package testBase;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    public Properties p;


    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {
    	p = GenericMethods.loadProperties("./src/test/resources/config.properties");
    	logger = LogManager.getLogger(this.getClass());

        switch (browser.toLowerCase()) {

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                driver = new ChromeDriver(options);
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("url"));
    }


    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed successfully");
        }
    }
}
