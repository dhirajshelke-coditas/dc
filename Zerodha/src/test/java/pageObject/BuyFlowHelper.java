package pageObject;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import testBase.BaseClass;

public class BuyFlowHelper {

    private final BuyFlow buyflow;
    private final OrderDetailsPage orderPage;
    private final Logger logger = BaseClass.logger;

    public BuyFlowHelper(WebDriver driver) {
        this.buyflow   = new BuyFlow(driver);
        this.orderPage = new OrderDetailsPage(driver);
    }

    // Step 1 - Search, hover, open buy form

    public void openBuyForm(String stockName, String qty) {
        buyflow.searchStock(stockName);
        buyflow.hoverStock();
        buyflow.clickOnBuy();
        buyflow.navigateToRegular();
        buyflow.selectLongterm();
        buyflow.setQuantity(qty);
        logger.info("Buy form opened for stock: " + stockName + " | qty: " + qty);
    }

    // STEP 2a — Set order type: Market
    
    public void setMarketOrder() {
        buyflow.selectMarket();
        logger.info("Order type set to: MARKET");
    }

    // Step 2b - Set order type: Limit

    public void setLimitOrder(String price) {
        buyflow.selectLimit();
        buyflow.clearPrice();
        buyflow.setPrice(price);
        logger.info("Order type set to: LIMIT | price: " + price);
    }

    // Step 2c - Set order type: SL
    public void setSLOrder(String price, String triggerPrice) {
        buyflow.selectSL();
        buyflow.clearPrice();
        buyflow.setPrice(price);
        buyflow.clearTriggerPrice();
        buyflow.setTriggerPrice(triggerPrice);
        logger.info("Order type set to: SL | price: " + price + " | trigger: " + triggerPrice);
    }

    // Step 2d - Set order type: SL-M
    
    public void setSLMOrder(String triggerPrice) {
        buyflow.selectSLM();
        buyflow.clearTriggerPrice();
        buyflow.setTriggerPrice(triggerPrice);
        logger.info("Order type set to: SL-M | trigger: " + triggerPrice);
    }

    // Step 3a - Set validity: Day

    public void setDayValidity() {
        buyflow.clickAdvancedOptions();
        buyflow.selectDay();
        logger.info("Validity set to: DAY");
    }

    // Step 3b - Set validity: Immediate (IOC)

    public void setImmediateValidity() {
        buyflow.clickAdvancedOptions();
        buyflow.selectImmediate();
        logger.info("Validity set to: IOC");
    }

    // Step 4 - Enable Stoploss + Target checkboxes

    public void enableStoplossAndTarget() {
        buyflow.checkStoploss();
        buyflow.checkTarget();
        logger.info("Stoploss and Target enabled");
    }

    // Step 5 - Submit the order

    public void submitOrder() {
        buyflow.buyStock();
        logger.info("Order submitted");
    }

    // Teardown 1 - Dismiss toasts >> cancel >> verify order

    public void dismissAndVerify(String qty, String price, String trigger,
                                 String orderType, String productType,
                                 String validity, String stockName) throws InterruptedException {
        buyflow.clickOnCross();
        Thread.sleep(500);
        buyflow.clickOnCross();
        buyflow.clickCancel();
        Thread.sleep(500);
        orderPage.clickOrderStatus();
        orderPage.verifyOrder(qty, price, trigger, orderType, productType, validity, stockName);
        orderPage.clickCloseButton();
        logger.info("Order verified: " + orderType + " | " + validity);
    }

    // Teardown 2 - Dismiss toasts >> verify stoploss/target order

    public void dismissAndVerifyWithStoplossTarget(String qty, String price, String trigger,
                                                   String orderType, String productType,
                                                   String validity, String stockName,
                                                   String stoploss, String target) throws InterruptedException {
        buyflow.clickOnCross();
        Thread.sleep(500);
        buyflow.clickOnCross();
        Thread.sleep(500);
        orderPage.clickOrderStatus();
        orderPage.verifyStoplossTargetOrder(qty, price, trigger, orderType, productType,
                validity, stockName, stoploss, target);
        orderPage.clickCloseButton();
        logger.info("Stoploss/Target order verified: " + orderType + " | stoploss: " + stoploss + " | target: " + target);
    }

    // Teardown 3 - Verify invalid input then cancel

    public void verifyInvalidAndCancel() {
        buyflow.invalidQuantity_Price();
        buyflow.clickCancel();
        logger.info("Invalid input verified");
    }

    // Teardown 4 - Verify circuit breach then dismiss and cancel

    public void verifyCircuitAndCancel() {
        buyflow.verifyPriceMoreThanCircuit();
        buyflow.clickOnCross();
        buyflow.clickCancel();
        logger.info("Circuit break verified");
    }
}
