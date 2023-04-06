package com.gammax.ci.exchange.testcases.admin;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gammax.ci.gammax.pages.ConfirmYourOrderPage;
import com.gammax.ci.gammax.pages.Homepage;
import com.gammax.ci.gammax.pages.Loginpage;
import com.gammax.ci.gammax.pages.MetaMaskNotificationPage;
import com.gammax.ci.gammax.pages.MetamaskRegistrationPage;
import com.gammax.ci.gammax.testbase.Base;
import com.gammax.ci.gammax.testbase.ExcelData;
import com.relevantcodes.extentreports.LogStatus;

public class LimitTC extends Base{
	
	Loginpage loginPage=new Loginpage();
    Homepage homePage = new Homepage();
    MetaMaskNotificationPage metapage = new MetaMaskNotificationPage();

    MetamaskRegistrationPage registrationPage= new MetamaskRegistrationPage();
    ConfirmYourOrderPage confirmPage = new ConfirmYourOrderPage();
    
    @BeforeMethod
    public void login() throws Exception {
    	loginPage.LoginPageDriverRef(driver);
        homePage.HomePageDriverRef(Base.driver);
        registrationPage.MetamaskDriverRef(driver);

        extentTest.log(LogStatus.INFO, "TC Summary : Verify User is able to login to metamask app");
        registrationPage.switchToMetaMask();
        registrationPage.MetamaskDriverRef(driver);
        registrationPage.clickImportAnExistingWallet();
        registrationPage.clickIAgree();
        registrationPage.enterScretRecoryPhrase(CONFIG.passwordRecoveryPhrase());
        registrationPage.clickConfirmSecretPhrase();
        registrationPage.enterPassword(CONFIG.metamaskpassword());
        registrationPage.clickIUnderstandChkBox();
        registrationPage.clickImportMyWallet();
        registrationPage.clickGotIt();
        registrationPage.clickNext();
        registrationPage.clickDone();
        registrationPage.clickX();
        registrationPage.clickNetwork();
        registrationPage.clickAddNetwork();
        registrationPage.clickAdvanced();        
        registrationPage.clickShowTestNetworks();        
        registrationPage.clickSave();
        registrationPage.clickNetwork();
        registrationPage.clickGoerliTestNetwork();
        registrationPage.clickSave();
        registrationPage.switchToGammaX();
        homePage.clickConnectWallet();        
        homePage.HomePageDriverRef(driver);
        homePage.clickGetStarted();        
        homePage.clickMetaMask();        
        homePage.switchToMetaMaskNotification();       
        metapage.MetaMaskNotificationPage(driver);
        metapage.clickNext();       
        metapage.clickConnect();        
        metapage.clickSign();        
        metapage.switchToGammaX();
        homePage.VerifyAleart("Wallet connected successful!");
        driver.navigate().refresh();
    }
    
    @Test(dataProvider = "getData")
    public void verify_limitBuy(ExcelData data) throws Exception {

        setTestId(TEST_ID);
        homePage.enableConfWindow();
        homePage.selectCrypto(data.getCrypto());
        homePage.enterLimitPrice(data.getPrice());
        homePage.enterQty(data.getQuantity());
        homePage.selectTIF(data.getTif());
        homePage.clickBuy();
        confirmPage.ConfirmYourOrderPageDriverRef(driver);
        confirmPage.clickMarketBuy();
//        homePage.VerifyAleart("Buy "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");
        homePage.validatBuyOrderBook("",data.getQuantity());
    }
    
    @Test(dataProvider = "getData")
    public void verify_marketBuy(ExcelData data) throws Exception {

        setTestId(TEST_ID);
        homePage.enableConfWindow();
//        homePage.selectCrypto(data.getCrypto());
        homePage.clickMarket();
        homePage.enterQty(data.getQuantity());
        Thread.sleep(2000);
        homePage.clickMarketBuy_BuyButton();
        confirmPage.ConfirmYourOrderPageDriverRef(driver);
        confirmPage.clickMarketBuy();
//        homePage.VerifyAleart("Buy "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");

        //Need to be asked by Sanjiv
 //       homePage.validatBuyOrderBook("",data.getQuantity());
    }
    
    @Test(dataProvider = "getData")
    public void verify_limitSell(ExcelData data) throws Exception {

        setTestId(TEST_ID);
        homePage.enableConfWindow();
        homePage.selectCrypto(data.getCrypto());
        homePage.enterLimitPrice(data.getPrice());
        homePage.enterQty(data.getQuantity());
        homePage.selectTIF(data.getTif());
        homePage.clickSell();
        confirmPage.ConfirmYourOrderPageDriverRef(driver);
        confirmPage.clickSell();
//        homePage.VerifyAleart("Sell "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");
        homePage.validatSellOrderBook("",data.getQuantity());
    }
    
    @Test(dataProvider = "getData")
    public void verify_marketSell(ExcelData data) throws Exception {

        setTestId(TEST_ID);
        homePage.enableConfWindow();
        homePage.selectCrypto(data.getCrypto());
        homePage.clickMarket();
        homePage.enterQty(data.getQuantity());
        homePage.clickMarketSell_SellButton();
        confirmPage.ConfirmYourOrderPageDriverRef(driver);
        confirmPage.clickSell();
//        homePage.VerifyAleart("Sell "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");
        homePage.validatSellOrderBook("",data.getQuantity());
    }

}
