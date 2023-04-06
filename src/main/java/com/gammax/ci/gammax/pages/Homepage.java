package com.gammax.ci.gammax.pages;


import com.gammax.ci.gammax.core.BrowserDriver;
import com.gammax.ci.gammax.core.Element;
import com.gammax.ci.gammax.testbase.Base;
import com.gammax.ci.gammax.testbase.ExcelData;
import com.gammax.ci.gammax.testbase.JSWaiter;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class Homepage extends Base {

	WebDriver driver;
	Element element = new Element(driver);
	BrowserDriver browserDriver = new BrowserDriver();
	Base base = new Base();
	JSWaiter jSWaiter = new JSWaiter();
	static Logger logger = LogManager.getLogger(Homepage.class.getName());


	@FindBy(xpath ="//*[@id='dropdown-name']")
	WebElement loggedinUser;

//	@FindBy(xpath = "//div[text()='Connect Wallet']")
	@FindBy(xpath = "(//div[text()=' Connect Wallet '])[1]")
	WebElement connectWallet;

	@FindBy(xpath = "//*[text()=' Get started ']")
	WebElement getstarted;

	@FindBy(xpath = "//*[text()='MetaMask']")
	WebElement metaMask;

	@FindBy(xpath = "//*[text()='Sign']")
	WebElement sign;

	@FindBy(xpath = "//*[@aria-label='Wallet connected successful!]")
	WebElement successMessage;

	@FindBy(xpath = "//div[@role='alertdialog']")
	WebElement alertdialog;

	@FindBy(xpath = "//div[contains(text(),'Limit Price')]/following-sibling::div/input")
	WebElement limitPrice;

	@FindBy(xpath = "//div[contains(text(),'Quantity')]/following-sibling::div/input")
	WebElement quantity;
	
	@FindBy(xpath = "//div[contains(text(),'Stop Price')]/following-sibling::div/input")
	WebElement stopPrice;
	
	@FindBy(xpath = "//div[contains(text(),'Trigger Price')]/following-sibling::div/input")
	WebElement triggerPrice;

	@FindBy(xpath = "//div[contains(text(),'TIF')]/following-sibling::div")
	WebElement tif;

	@FindBy(xpath = "//div[contains(text(),'TIF')]/../following-sibling::div//div[contains(@class,'option-name')]")
	List<WebElement> tifOptions;

	@FindBy(xpath = "//button[@class='btn btn-success npd-btn-success shadow-none']")
	WebElement buy;

	@FindBy(xpath = "//button[@class='btn btn-danger npd-btn-danger shadow-none']")
	WebElement sell;

	@FindBy(linkText = "Market")
	WebElement market;
	
	@FindBy(xpath = "//div[contains(text(),'Deposit')]")
	WebElement deposit;
	
	@FindBy(xpath = "//div[contains(text(),'Withdrawal')]")
	WebElement withdrawal;
	
	@FindBy(xpath = "//div[contains(@class,'amount-container')]//input")
	WebElement amount;
	
	@FindBy(xpath = "//div[contains(text(),'Confirm Deposit')]")
	WebElement confirmDeposit;
	
	@FindBy(xpath = "//div[contains(text(),' Confirm Withdrawal ')]")
	WebElement confirmWithdrawal;
	
	@FindBy(css = "[class='amount-value']")
	List<WebElement> balance;
	
	@FindBy(xpath = "//div[text()='Place Order']/following-sibling::div/a")
	WebElement calculator;
	
	@FindBy(xpath = "//div[@class='options-name' and text()=' Mark Price ']/following-sibling::div")
	WebElement markPrice;
	
	@FindBy(xpath = "//span[@class='selected-option-name' and contains(text(),'Stop Limit')]")
	WebElement stopLimit;
	
	@FindBy(xpath = "//div[text()='Trigger']")
	WebElement trigger;
	
	@FindBy(css = "[class='dropdown-content dropdown-content-show'] > div > div > div")
	List<WebElement> triggerOptions;
	
	@FindBy(xpath = "//span[@class='market-name']")
	WebElement crypto;
	
	@FindBy(css="[class='wallet-name']")
	List<WebElement> walletnames;
	
	@FindBy(partialLinkText = "Order History")
	WebElement orderHistory;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[1]")
	List<WebElement> tsymbol;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[2]/span")
	List<WebElement> tqty;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[3]")
	List<WebElement> torderPrice;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[5]")
	List<WebElement> tStopPrice;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[7]")
	List<WebElement> tType;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[8]/span")
	List<WebElement> stoptType;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[8]/span[1]")
	List<WebElement> tOrderID;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[9]")
	List<WebElement> tStatus;
	
	@FindBy(xpath = "//div[contains(@class,'body-row')]/div[10]")
	List<WebElement> tTime;
	
	@FindBy(xpath = "//*[@selectedoption='trade.placeorder.Tab4']//div[contains(@class,'option-name')]")
	List<WebElement> tabs;
	
	@FindBy(partialLinkText = "Stops")
	WebElement stops;

	@FindBy(xpath ="//div[@class='bids']//div[@class='tbl-striped trade-rows ng-star-inserted']/div/div[1]")
	List<WebElement> buyPrice;

	@FindBy(xpath ="//div[@class='bids']//div[@class='tbl-striped trade-rows ng-star-inserted']/div/div[2]")
	List<WebElement> buySize;

	@FindBy(xpath ="//*[@id='messageBody']/div/div/div[1]")
	List<WebElement> sellPrice;

	@FindBy(xpath ="//div[@class='asks']//div[@class='tbl-striped trade-rows ng-star-inserted']/div/div[2]")
	List<WebElement> sellSize;
	
	@FindBy(xpath = "//mat-icon[@data-mat-icon-name='setting']")
	WebElement settings;
	
	@FindBy(xpath = "//span[text()='Show Buy/Sell Confirmation Window']/following-sibling::mat-slide-toggle//input")
	WebElement confWindow;
	
	@FindBy(xpath = "//mat-icon[@data-mat-icon-name='cancel']")
	WebElement closex;

	public void HomePageDriverRef(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 45);
		PageFactory.initElements(factory, this);
		element = new Element(driver);
		JSWaiter.setDriver(driver);
	}
	
	public void clickWithDrawal() {
		driver.navigate().refresh();
		withdrawal.click();
		extentTest.log(LogStatus.INFO, "Click on With Drawal");
        takeScreenShot();
	}


	public void clickDeposit() {
		driver.navigate().refresh();
		element.click(driver, deposit);
		extentTest.log(LogStatus.INFO, "Click on Deposit");
        takeScreenShot();
	}
	
	public void enterAmount(String amt) {
		amount.clear();
		amount.sendKeys(amt);
		extentTest.log(LogStatus.INFO, "Enter Amount :: "+amt);
        takeScreenShot();
	}
	
	public void clickconfirmDeposit() {
		element.click(driver, confirmDeposit);
		extentTest.log(LogStatus.INFO, "Click on Confirm Deposit");
        takeScreenShot();
	}
	
	public void clickconfirmWithdrawal() {
		confirmWithdrawal.click();
		extentTest.log(LogStatus.INFO, "Click on Confirm With Drawal");
        takeScreenShot();
	}
	
	public String getBalance() {
		extentTest.log(LogStatus.INFO, "Balance :: "+balance.get(0).getText());
		return balance.get(0).getText();
	}
	
	public String getBalanceonWindow() {
		extentTest.log(LogStatus.INFO, "Balance :: "+balance.get(1).getText());
		return balance.get(1).getText();
	}
	
	public void isconfirmDepositDisabled() {
		if(confirmDeposit.isEnabled())
			extentTest.log(LogStatus.INFO, "Confirm Deposit Should be Disabled :: "+confirmDeposit.isEnabled());
		else
			extentTest.log(LogStatus.INFO, "Confirm Deposit Should be Disabled :: "+confirmDeposit.isEnabled());
		takeScreenShot();
	}

	public void clickConnectWallet() {
		connectWallet.click();
		extentTest.log(LogStatus.INFO, "Click on Connect Wallet");
        takeScreenShot();
	}
	
	public void clickGetStarted() {
		getstarted.click();
		extentTest.log(LogStatus.INFO, "Click on Get Started");
        takeScreenShot();
	}
	
	public void clickMetaMask() {
		metaMask.click();
		extentTest.log(LogStatus.INFO, "Click on MetaMask");
        takeScreenShot();
	}

	public void switchToMetaMaskNotification() {
		while (true) {
			if (driver.getWindowHandles().size() == 3) {
				break;
			}
		}
		Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains("MetaMask Notification")) {
				extentTest.log(LogStatus.INFO, "Switch to Metamask Notofication");
		        takeScreenShot();
				break;
			}
		}
	}

	public void verifyUserDropdownMenu() throws InterruptedException {
		base.timeinterval(2);

		element.waitVisibility(driver, loggedinUser, 20);
		element.click(driver, loggedinUser);
		logger.info("Logged in User name drop-down is clicked");
		Base.extentTest.log(LogStatus.PASS, "Logged in User name drop-down is clicked");
		Base.takeScreenShot();
		base.timeinterval(2);
	}
	
	public String getDialogMessage(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(alertdialog));
		return alertdialog.getText();	
	}

	public void enterLimitPrice(String price){
		limitPrice.clear();
		limitPrice.sendKeys(price);
		extentTest.log(LogStatus.INFO, "Enter LIMIT PRICE :: "+price);
        takeScreenShot();
	}

	public void enterQty(String qty){
		quantity.clear();
		quantity.sendKeys(qty);
		extentTest.log(LogStatus.INFO, "Enter QTY :: "+qty);
        takeScreenShot();
	}

	public void selectTIF(String option){
		tif.click();
		selectTifDropdown(option);
		extentTest.log(LogStatus.INFO, "Select TIF :: "+option);
        takeScreenShot();
	}

	public void selectTifDropdown(String option){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(tifOptions.get(0)));
		for(WebElement tifOption:tifOptions){
			if(tifOption.getText().trim().contains(option))
				tifOption.click();
		}
	}

	@FindBy(xpath = "//div[@class='order-btn-control']/button[contains(text(),'Sell')]")
	WebElement MarketSell_SellButton;

	@FindBy(xpath = "//div[@class='order-btn-control']/button[contains(text(),'Buy')]")
	WebElement MarketBuy_BuyButton;

	public void clickMarketSell_SellButton(){
		element.waitClickable(driver, MarketSell_SellButton, 10);
		element.clickByJs(driver, MarketSell_SellButton);
		extentTest.log(LogStatus.INFO, "Click on Market Sell > Sell Button");
		takeScreenShot();
	}
	public void clickMarketBuy_BuyButton(){
		element.waitClickable(driver, MarketBuy_BuyButton, 10);
		element.clickByJs(driver, MarketBuy_BuyButton);
		extentTest.log(LogStatus.INFO, "Click on Market Buy > Buy Button");
		takeScreenShot();
	}

	public void clickBuy(){
		element.waitClickable(driver, buy, 10);
		element.clickByJs(driver, buy);
		extentTest.log(LogStatus.INFO, "Click on BUY");
        takeScreenShot();
	}

	public void clickSell(){
		element.waitClickable(driver, sell, 15);
		element.clickByJs(driver, sell);
		extentTest.log(LogStatus.INFO, "Click on SELL");
        takeScreenShot();
	}

	public void clickMarket(){
		market.click();
		extentTest.log(LogStatus.INFO, "Clicked on Market");
        takeScreenShot();
	}

	public void VerifyAleart(String message) throws Exception {
		// TODO Auto-generated method stub
		element.waitVisibility(driver, alertdialog, 10);
		if(alertdialog.getText().trim().contains(message)) {
			extentTest.log(LogStatus.PASS, "Dialog with text "+alertdialog.getText().trim()+" is displayed");
			takeScreenShot();
		}else {
			extentTest.log(LogStatus.FAIL, "Dialog with text "+alertdialog.getText().trim()+" is NOT displayed");
			takeScreenShot();
		}
		while(true) {
			if(driver.getPageSource().contains(message)) {
				Thread.sleep(1000);
			}else {
				break;
			}
		}
	}
	
	public String getMarkPrice() {
		return markPrice.getText().trim();
	}
	
	public void selectStopLimitTab(String tab) throws InterruptedException {
		Thread.sleep(1000);
		element.clickByJs(driver, stopLimit);
		Thread.sleep(2000);
		element.click(driver, tabs.stream().filter(e -> e.getText().contains(tab)).findFirst().get());
		extentTest.log(LogStatus.PASS, "Click on "+tab);
		takeScreenShot();
	}
	
	public void enterstopPrice(String amount) {
		element.sendKeys(stopPrice, amount);
		extentTest.log(LogStatus.PASS, "STOP Price :: "+amount);
		takeScreenShot();
	}
	
	public void selectTrigger(String strtrigger) {
		element.click(driver, trigger);
		extentTest.log(LogStatus.PASS, "Click On Trigger Dropdown");
		takeScreenShot();
		triggerOptions.stream().filter(e-> e.getText().equalsIgnoreCase(strtrigger))
		.findFirst().get().click();
		extentTest.log(LogStatus.PASS, "Select Trigger Dropdown :: "+strtrigger);
		takeScreenShot();
	}
	
	public void waitForSpinner() throws Exception {
		while(true) {
			if(driver.findElements(By.xpath("//*[@class='spinner ng-star-inserted']")).size() == 0) {
				break;
			}else {
				Thread.sleep(1000);
			}
		}
	}
	
	public void selectCrypto(String cryptoEx) throws Exception {
		Thread.sleep(2000);
		element.click(driver, crypto);
		extentTest.log(LogStatus.PASS, "Click On Crypto Dropdown");
		takeScreenShot();
		Thread.sleep(2000);
		walletnames.stream().filter(e -> e.getText().trim().equalsIgnoreCase(cryptoEx))
		.findFirst().get().click();
		extentTest.log(LogStatus.PASS, "Select "+cryptoEx+" On Crypto Dropdown");
		takeScreenShot();
		Thread.sleep(5000);
	}
	
	public String getLimitPrice() {
		return limitPrice.getText();
	}
	
	public void clickOrderHistory() throws InterruptedException {
		Thread.sleep(2000);
		element.click(driver, orderHistory);
		extentTest.log(LogStatus.PASS, "Click On Order History");
		takeScreenShot();
	}
	
	public void verifyOrderBook(String crypto, String qty, String stopprice, String type, String Status) {
		if(tsymbol.get(0).getText().trim().equalsIgnoreCase(crypto)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+crypto+" ACTUAL :: "+tsymbol.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+crypto+" ACTUAL :: "+tsymbol.get(0).getText().trim());
		}
		
		if(tqty.get(0).getText().trim().contains(qty)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+qty+" ACTUAL :: "+tqty.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+qty+" ACTUAL :: "+tqty.get(0).getText().trim());
		}
		
		if(tStopPrice.get(0).getText().trim().contains(stopprice)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+stopprice+" ACTUAL :: "+tStopPrice.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+stopprice+" ACTUAL :: "+tStopPrice.get(0).getText().trim());
		}
		
		if(tType.get(0).getText().trim().equalsIgnoreCase(type)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+type+" ACTUAL :: "+tType.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+type+" ACTUAL :: "+tType.get(0).getText().trim());
		}
		
		if(tStatus.get(0).getText().trim().equalsIgnoreCase(Status)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+Status+" ACTUAL :: "+tStatus.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+Status+" ACTUAL :: "+tStatus.get(0).getText().trim());
		}
		
		extentTest.log(LogStatus.PASS, "ORDER ID :: "+tOrderID.get(0).getText().trim());
				
	}
	
	public void clickStops() {
		element.click(driver, stops);
		extentTest.log(LogStatus.PASS, "Click on STOPS");
		takeScreenShot();
	}

	public void verifyStops(String crypto, String qty, String stopprice, String type, String Status) {
		if(tsymbol.get(0).getText().trim().equalsIgnoreCase(crypto)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+crypto+" ACTUAL :: "+tsymbol.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+crypto+" ACTUAL :: "+tsymbol.get(0).getText().trim());
		}
		
		if(tqty.get(0).getText().trim().contains(qty)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+qty+" ACTUAL :: "+tqty.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+qty+" ACTUAL :: "+tqty.get(0).getText().trim());
		}
		
		if(tStopPrice.get(0).getText().trim().contains(stopprice)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+stopprice+" ACTUAL :: "+tStopPrice.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+stopprice+" ACTUAL :: "+tStopPrice.get(0).getText().trim());
		}
		
		if(stoptType.get(0).getText().trim().equalsIgnoreCase(type)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+type+" ACTUAL :: "+stoptType.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+type+" ACTUAL :: "+stoptType.get(0).getText().trim());
		}
		
		if(tStatus.get(0).getText().trim().equalsIgnoreCase(Status)) {
			extentTest.log(LogStatus.PASS, "EXPECTED :: "+Status+" ACTUAL :: "+tStatus.get(0).getText().trim());
		}else {
			extentTest.log(LogStatus.FAIL, "EXPECTED :: "+Status+" ACTUAL :: "+tStatus.get(0).getText().trim());
		}
		
	}

	public void enterTriggerPrice(String string) {
		element.sendKeys(triggerPrice, string);
		extentTest.log(LogStatus.PASS, "Enter Trigger Price :: "+string);
		takeScreenShot();
		
	}

	public void validatBuyOrderBook(String price, String qty){
		boolean bool = false;
		for(int i = 0; i<buyPrice.size(); i++) {
			if(price.contains(buyPrice.get(i).getText().trim()) && buySize.get(i).getText().trim().equals(qty)) {
				bool = true;
				break;
			}
		}
		if(bool){
			extentTest.log(LogStatus.PASS, "Record Exists with Price :: "+price+" Qyantity ::"+qty);
		}else{
			extentTest.log(LogStatus.FAIL, "Record DOESNT Exists with Price :: "+price+" Qyantity ::"+qty);
		}
	}

	public void validatSellOrderBook(String price, String qty){
		boolean bool = false;
		for(int i = 0; i<sellPrice.size(); i++) {
			if(sellPrice.get(i).getText().trim().equals(price) && sellSize.get(i).getText().trim().equals(qty)) {
				bool = true;
				break;
			}
		}
		if(bool){
			extentTest.log(LogStatus.PASS, "Record Exists with Price :: "+price+" Qyantity ::"+qty);
		}else{
			extentTest.log(LogStatus.FAIL, "Record DOESNT Exists with Price :: "+price+" Qyantity ::"+qty);
		}
	}

	public double getSellOrerBookPrice(String price) throws InterruptedException {
		Thread.sleep(2000);
		if(sellPrice.size() != 0) 
			return Double.parseDouble(sellPrice.get(sellPrice.size()-1).getText().trim()) - 0.1;
		else
			return Double.parseDouble(price);
		
	}

	public double getBuyOrerBookPrice(String price) {
		if(buyPrice.size() != 0) 
			return Double.parseDouble(buyPrice.get(buyPrice.size()-1).getText().trim()) - 0.1;
		else 
			return Double.parseDouble(price);
	}
	
	public void enableConfWindow() {
		element.click(driver, settings);
		extentTest.log(LogStatus.PASS, "Click on Settings Icon");
		takeScreenShot();
		if(confWindow.getAttribute("aria-checked").equals("false")) {
			element.click(driver, confWindow);
			extentTest.log(LogStatus.PASS, "Click on Show Buy/Sell Confirmation Window Checkbox");
			takeScreenShot();
		}
		element.click(driver, closex);
		extentTest.log(LogStatus.PASS, "Click on X Icon");
	}

}
