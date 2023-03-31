package com.gammax.ci.exchange.testcases.admin;

import com.gammax.ci.gammax.pages.*;
import com.gammax.ci.gammax.testbase.Base;
import com.gammax.ci.gammax.testbase.ExcelData;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.NoSuchElementException;

public class DataCreationTC extends Base {

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
    }

    @Test(dataProvider = "getData")
    public void data_limitBuy(ExcelData data) throws Exception {

        setTestId(TEST_ID);
        homePage.selectCrypto(data.getCrypto());
        for(int i = 0; i<5; i++) {
	        double limitprice = homePage.getBuyOrerBookPrice(data.getPrice());
	        homePage.enterLimitPrice(""+limitprice);
	        homePage.enterQty(data.getQuantity());
	        homePage.selectTIF(data.getTif());
	        homePage.clickBuy();
	        confirmPage.ConfirmYourOrderPageDriverRef(driver);
	        confirmPage.clickBuy();
	        homePage.VerifyAleart("Buy "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");
        }
    }

    @Test(dataProvider = "getData")
    public void data_limitSell(ExcelData data) throws Exception {
        setTestId(TEST_ID);
        homePage.selectCrypto(data.getCrypto());
        for(int i = 0; i<5; i++) {
	        double limitprice = homePage.getSellOrerBookPrice(data.getPrice());    
	        homePage.enterLimitPrice(""+limitprice);
	        homePage.enterQty(data.getQuantity());
	        homePage.selectTIF(data.getTif());
	        homePage.clickSell();
	        confirmPage.ConfirmYourOrderPageDriverRef(driver);
	        confirmPage.clickSell();
	        homePage.VerifyAleart("Sell "+data.getQuantity()+" Contracts of "+data.getCrypto()+" at ");
        }
    }
}
