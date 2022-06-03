package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PopupPage;
import utils.SeleniumUtils;

public class PopupTest extends BaseTest {
    PopupPage popupPage;

    @BeforeMethod
    public void localSetUp(){

        popupPage = new PopupPage(getDriver());
    }

    @Test(testName = "Popup") // Practice to get massage in Popup
    public void test123() {
        System.out.println(popupPage.getText(popupPage.messagePopup));
        popupPage.click(popupPage.xBtn);

    }

    @Test(testName = "Validate pop-up text")
    public void test01(){
        System.out.println(popupPage.getText(popupPage.popUpText));
        popupPage.click(popupPage.closePopUpBtn);
    }

    @Test void test02(){
        popupPage.waitForElementVisibility(popupPage.popUpText);
        popupPage.click(popupPage.closePopUpBtn);
        popupPage.moveIntoView(popupPage.footer);
        popupPage.click(popupPage.facebookBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle, "The Weather Channel - Home");

    }

    @Test void test03(){
        popupPage.waitForElementVisibility(popupPage.popUpText);
        popupPage.click(popupPage.closePopUpBtn);
        popupPage.moveIntoView(popupPage.footer);
        popupPage.click(popupPage.twitterBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle, "The Weather Channel (@weatherchannel) / Twitter");

    }

    @Test void test04(){
        popupPage.waitForElementVisibility(popupPage.popUpText);
        popupPage.click(popupPage.closePopUpBtn);
        popupPage.moveIntoView(popupPage.footer);
        popupPage.click(popupPage.youtubeBtn);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle, "The Weather Channel - YouTube");

    }
}
/*
1. Navigate to https://weather.com

2. Wait until pop-up window appears

3. Get the text of the pop-up window and close it
 */