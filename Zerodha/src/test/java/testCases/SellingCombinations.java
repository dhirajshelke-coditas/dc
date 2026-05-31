package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.BuyFlow;
import pageObject.BuyFlowHelper;
import testBase.BaseClass;

public class SellingCombinations extends BaseClass {

    private BuyFlowHelper helper;
    private BuyFlow buyflow;
    

    @BeforeMethod
    public void initHelper() {
        helper = new BuyFlowHelper(driver);
        buyflow = new BuyFlow(driver);
    }

    // COMBINATION TESTS (1–12)
    
    @Test(description = "Regular | Longterm | Market | Day", priority = 1)
    public void regular_Longterm_Market_Day() throws InterruptedException {
        logger.info("***** Combination 1 started *****");
        helper.buyOrder(true,"Coal", "market", "1", false, "0", false, "0", "day", false);
        logger.info("***** Combination 1 ended *****");
    }

    @Test(description = "Regular | Longterm | Market | Immediate", priority = 2)
    public void regular_Longterm_Market_Immediate() throws InterruptedException {
        helper.buyOrder(true,"Coal", "market", "1", false, "0", false, "0", "immediate", false);
        logger.info("***** Combination 2 ended *****");
    }

    @Test(description = "Regular | Longterm | Limit | Day", priority = 3)
    public void regular_Longterm_Limit_Day() throws InterruptedException {
        logger.info("***** Combination 3 started *****");
        helper.buyOrder(true,"Coal", "limit", "1", true, "466", false, "0", "day", false);
        logger.info("***** Combination 3 ended *****");
    }

    @Test(description = "Regular | Longterm | Limit | Immediate", priority = 4)
    public void regular_Longterm_Limit_Immediate() throws InterruptedException {
        logger.info("***** Combination 4 started *****");
        helper.buyOrder(true,"Coal", "limit", "1", true, "466", false, "0", "immediate", false);
        logger.info("***** Combination 4 ended *****");
    }

    @Test(description = "Regular | Longterm | SL | Day", priority = 5)
    public void regular_Longterm_SL_Day() throws InterruptedException {
        logger.info("***** Combination 5 started *****");
        helper.buyOrder(true,"Coal", "sl", "1", true, "456", true, "454", "day", false);
        logger.info("***** Combination 5 ended *****");
    }

    @Test(description = "Regular | Longterm | SL | Immediate", priority = 6)
    public void regular_Longterm_SL_Immediate() throws InterruptedException {
        logger.info("***** Combination 6 started *****");
        helper.buyOrder(true,"Coal", "sl", "1", true, "456", true, "454", "immediate", false);
        logger.info("***** Combination 6 ended *****");
   }

    @Test(description = "Regular | Longterm | SL-M | Day", priority = 7)
    public void regular_Longterm_SLM_Day() throws InterruptedException {
        logger.info("***** Combination 7 started *****");
        helper.buyOrder(true,"Coal", "slm", "1", false, "0", true, "456", "day", false);
        logger.info("***** Combination 7 ended *****");
    }

    @Test(description = "Regular | Longterm | SL-M | Immediate", priority = 8)
    public void regular_Longterm_SLM_Immediate() throws InterruptedException {
        logger.info("***** Combination 8 started *****");
        helper.buyOrder(true,"Coal", "slm", "1", false, "0", true, "456", "immediate", false);
        logger.info("***** Combination 8 ended *****");
    }


}
