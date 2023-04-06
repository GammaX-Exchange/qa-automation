package com.gammax.ci.gammax.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.gammax.ci.gammax.core.BrowserDriver;
import com.gammax.ci.gammax.core.Element;
import com.gammax.ci.gammax.testbase.Base;
import com.gammax.ci.gammax.testbase.JSWaiter;
import com.relevantcodes.extentreports.LogStatus;

public class ConfirmYourOrderPage extends Base{

	WebDriver driver;
	Element element = new Element(driver);
	BrowserDriver browserDriver = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	static Logger logger = LogManager.getLogger(Homepage.class.getName());
	
    @FindBy(xpath = "//button[@class='btn btn-primary btn-block' and contains(text(),'Sell')]")
    private WebElement sell;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block ng-star-inserted' and contains(text(),'Buy')]")
	private WebElement buy;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-block' and contains(text(),'Buy')]")
	private WebElement marketbuy;
    
    public void ConfirmYourOrderPageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);

	}

    public void clickBuy(){
    	element.waitClickable(driver, buy, 10);
    	element.clickByJs(driver, buy);
    	extentTest.log(LogStatus.INFO, "Click on BUY");
        takeScreenShot();
    }

	public void clickMarketBuy(){
		element.waitClickable(driver, marketbuy, 10);
		element.clickByJs(driver, marketbuy);
		extentTest.log(LogStatus.INFO, "Click on Market BUY");
		takeScreenShot();
	}

    public void clickSell() throws InterruptedException {
    	element.waitClickable(driver, sell, 10);
		Thread.sleep(2000);
    	element.click(driver, sell);
    	extentTest.log(LogStatus.INFO, "Click on SELL");
        takeScreenShot();
    }
}
