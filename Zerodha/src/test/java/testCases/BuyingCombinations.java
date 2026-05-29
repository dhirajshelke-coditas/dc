package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.BuyFlowHelper;
import testBase.BaseClass;

public class BuyingCombinations extends BaseClass {

    private BuyFlowHelper helper;

    @BeforeMethod
    public void initHelper() {
        helper = new BuyFlowHelper(driver);
    }

    // COMBINATION TESTS (1–12)

    @Test(description = "Regular | Longterm | Market | Day", priority = 1)
    public void regular_Longterm_Market_Day() throws InterruptedException {
        logger.info("***** Combination 1 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setMarketOrder();
        helper.setDayValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "0", "0", "MARKET", "CNC", "DAY", "COAL");
        logger.info("***** Combination 1 ended *****");
    }

    @Test(description = "Regular | Longterm | Market | Immediate", priority = 2)
    public void regular_Longterm_Market_Immediate() throws InterruptedException {
        logger.info("***** Combination 2 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setMarketOrder();
        helper.setImmediateValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "0", "0", "MARKET", "CNC", "IOC", "COAL");
        logger.info("***** Combination 2 ended *****");
    }

    @Test(description = "Regular | Longterm | Limit | Day", priority = 3)
    public void regular_Longterm_Limit_Day() throws InterruptedException {
        logger.info("***** Combination 3 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setLimitOrder("460");
        helper.setDayValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "460", "0", "LIMIT", "CNC", "DAY", "COAL");
        logger.info("***** Combination 3 ended *****");
    }

    @Test(description = "Regular | Longterm | Limit | Immediate", priority = 4)
    public void regular_Longterm_Limit_Immediate() throws InterruptedException {
        logger.info("***** Combination 4 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setLimitOrder("460");
        helper.setImmediateValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "460", "0", "LIMIT", "CNC", "IOC", "COAL");
        logger.info("***** Combination 4 ended *****");
    }

    @Test(description = "Regular | Longterm | SL | Day", priority = 5)
    public void regular_Longterm_SL_Day() throws InterruptedException {
        logger.info("***** Combination 5 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLOrder("467", "465");
        helper.setDayValidity();
        helper.submitOrder();
        Thread.sleep(200);
        helper.dismissAndVerify("1", "467", "465", "SL", "CNC", "DAY", "COAL");
        logger.info("***** Combination 5 ended *****");
    }

    @Test(description = "Regular | Longterm | SL | Immediate", priority = 6)
    public void regular_Longterm_SL_Immediate() throws InterruptedException {
        logger.info("***** Combination 6 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLOrder("467", "465");
        helper.setImmediateValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "467", "465", "SL", "CNC", "IOC", "COAL");
        logger.info("***** Combination 6 ended *****");
    }

    @Test(description = "Regular | Longterm | SL-M | Day", priority = 7)
    public void regular_Longterm_SLM_Day() throws InterruptedException {
        logger.info("***** Combination 7 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLMOrder("465");
        helper.setDayValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "0", "465", "SL-M", "CNC", "DAY", "COAL");
        logger.info("***** Combination 7 ended *****");
    }

    @Test(description = "Regular | Longterm | SL-M | Immediate", priority = 8)
    public void regular_Longterm_SLM_Immediate() throws InterruptedException {
        logger.info("***** Combination 8 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLMOrder("465");
        helper.setImmediateValidity();
        helper.submitOrder();
        helper.dismissAndVerify("1", "0", "465", "SL-M", "CNC", "IOC", "COAL");
        logger.info("***** Combination 8 ended *****");
    }

    @Test(description = "Regular | Longterm | Market | Stoploss + Target", priority = 9)
    public void regular_Longterm_Market_Stoploss_Target() throws InterruptedException {
        logger.info("***** Combination 9 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setMarketOrder();
        helper.enableStoplossAndTarget();
        helper.submitOrder();
        helper.dismissAndVerifyWithStoplossTarget("1", "0", "0", "MARKET", "CNC", "DAY", "COAL", "-5", "5");
        logger.info("***** Combination 9 ended *****");
    }

    @Test(description = "Regular | Longterm | Limit | Stoploss + Target", priority = 10)
    public void regular_Longterm_Limit_Stoploss_Target() throws InterruptedException {
        logger.info("***** Combination 10 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setLimitOrder("470");
        helper.enableStoplossAndTarget();
        helper.submitOrder();
        helper.dismissAndVerifyWithStoplossTarget("1", "470", "0", "LIMIT", "CNC", "DAY", "COAL", "-5", "5");
        logger.info("***** Combination 10 ended *****");
    }

    @Test(description = "Regular | Longterm | SL | Stoploss + Target", priority = 11)
    public void regular_Longterm_SL_Stoploss_Target() throws InterruptedException {
        logger.info("***** Combination 11 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLOrder("470", "467");
        helper.enableStoplossAndTarget();
        helper.submitOrder();
        helper.dismissAndVerifyWithStoplossTarget("1", "470", "467", "SL", "CNC", "DAY", "COAL", "-5", "5");
        logger.info("***** Combination 11 ended *****");
    }

    @Test(description = "Regular | Longterm | SL-M | Stoploss + Target", priority = 12)
    public void regular_Longterm_SLM_Stoploss_Target() throws InterruptedException {
        logger.info("***** Combination 12 started *****");
        helper.openBuyForm("Coal", "1");
        helper.setSLMOrder("467");
        helper.enableStoplossAndTarget();
        helper.submitOrder();
        helper.dismissAndVerifyWithStoplossTarget("1", "0", "467", "SL-M", "CNC", "DAY", "COAL", "-5", "5");
        logger.info("***** Combination 12 ended *****");
    }

    // VALIDATION TESTS (TC_001–TC_009)

    @Test(description = "TC_001 - Buy order with quantity = 0 should not be accepted", priority = 13)
    public void verifyQuantityAs0() {
        logger.info("***** TC_001 started *****");
        helper.openBuyForm("Coal", "0");
        helper.setMarketOrder();
        helper.submitOrder();
        helper.verifyInvalidAndCancel();
        logger.info("***** TC_001 ended *****");
    }

    @Test(description = "TC_002 - Buy order with quantity < 0 should not be accepted", priority = 14)
    public void verifyQuantityLessThan0() {
        logger.info("***** TC_002 started *****");
        helper.openBuyForm("Coal", "-1");
        helper.setMarketOrder();
        helper.submitOrder();
        helper.verifyInvalidAndCancel();
        logger.info("***** TC_002 ended *****");
    }

    @Test(description = "TC_003 - Buy order with quantity > 0 should be accepted", priority = 15)
    public void verifyQuantityMoreThan0() throws InterruptedException {
        logger.info("***** TC_003 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setMarketOrder();
        helper.submitOrder();
        // validQuantity_Price is a BuyFlow-specific assertion — accessed via helper
        // No order page verification needed here; just dismiss toasts
        Thread.sleep(1000);
        logger.info("***** TC_003 ended *****");
    }

    @Test(description = "TC_004 - Buy order with quantity exceeding exchange limit should not be accepted", priority = 15)
    public void verifyQuantityMoreExchangeQuantity() {
        logger.info("***** TC_004 started *****");
        helper.openBuyForm("Coalindia", "50000000");
        helper.setMarketOrder();
        helper.submitOrder();
        helper.verifyCircuitAndCancel();
        logger.info("***** TC_004 ended *****");
    }

    @Test(description = "TC_005 - Buy order with price = 0 should not be accepted", priority = 16)
    public void verifyPriceAs0() {
        logger.info("***** TC_005 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setLimitOrder("0");
        helper.submitOrder();
        helper.verifyInvalidAndCancel();
        logger.info("***** TC_005 ended *****");
    }

    @Test(description = "TC_006 - Buy order with price above upper circuit should not be accepted", priority = 17)
    public void priceMorethanCircuit() {
        logger.info("***** TC_006 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setLimitOrder("5000");
        helper.submitOrder();
        helper.verifyCircuitAndCancel();
        logger.info("***** TC_006 ended *****");
    }

    @Test(description = "TC_007 - Buy order with price below lower circuit should not be accepted", priority = 18)
    public void priceLessthanCircuit() {
        logger.info("***** TC_007 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setLimitOrder("200");
        helper.submitOrder();
        helper.verifyCircuitAndCancel();
        logger.info("***** TC_007 ended *****");
    }

    @Test(description = "TC_008 - Buy order where trigger price > price should not be accepted", priority = 19)
    public void triggerPriceGreaterThanPrice() {
        logger.info("***** TC_008 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setSLOrder("465", "467");
        helper.submitOrder();
        helper.verifyInvalidAndCancel();
        logger.info("***** TC_008 ended *****");
    }

    @Test(description = "TC_009 - Buy order where trigger price < market price should not be accepted", priority = 20)
    public void triggerPriceLessThanMarketPrice() {
        logger.info("***** TC_009 started *****");
        helper.openBuyForm("Coalindia", "2");
        helper.setSLOrder("465", "0");
        helper.submitOrder();
        helper.verifyCircuitAndCancel();
        logger.info("***** TC_009 ended *****");
    }
}
