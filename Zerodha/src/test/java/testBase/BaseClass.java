package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;
    public Properties p;


    @BeforeTest
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

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


    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("TEST FAILED: " + result.getName());
         //   takeScreenshot(result.getName());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("TEST PASSED: " + result.getName());
        } else {
            logger.warn("TEST SKIPPED: " + result.getName());
        }
    }

//    public static void takeScreenshot(String testName) {
//        try {
//            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            String path = System.getProperty("user.dir")+"/reports/" + testName + "_" + timestamp + ".png";
//            File src  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File dest = new File(path);
//            FileUtils.copyFile(src, dest);
//            logger.info("Screenshot saved: " + path);
//        } catch (IOException e) {
//            logger.error("Failed to save screenshot for: " + testName, e);
//        }
//    }

//    @AfterClass
//    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//            logger.info("Browser closed successfully");
//        }
//    }
}
