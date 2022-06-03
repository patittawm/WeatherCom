package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FollowingPage;
import utils.SeleniumUtils;

import java.util.List;

import static base.BasePage.switchToNextWindow;

public class FollowingTest extends BaseTest {
    FollowingPage followingPage;

    @BeforeMethod
    public void localSetUp(){

        followingPage = new FollowingPage(getDriver());
    }

    @Test(testName = "Connect Social")
    public void test3456() throws InterruptedException {
        //Close Pop-up
        followingPage.waitForElementVisibility(getDriver().findElement(By.xpath("//div//h2[text()='Your Privacy']")));
        getDriver().findElement(By.xpath("//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")).click();

        //scroll down to footer

        followingPage.moveIntoView(getDriver().findElement(By.xpath("//span[@class='Footer--connect--x2PKn']")));

        //Click to FB TW IG YT
        followingPage.waitForElementVisibility(getDriver().findElement(By.xpath("//span[@class='Footer--connect--x2PKn']")));

        List<WebElement> links = getDriver().findElements(By.xpath("//div[@class='Footer--socialLogos--2MwDy']//a"));
        links.forEach(link -> link.click());

        switchToNextWindow(getDriver());
    }

    @Test()
    public void test02(){
        followingPage.click(followingPage.xBtn); //close popup
        followingPage.moveIntoView(followingPage.footer);
        followingPage.click(followingPage.facebook);
        String actualTitle = SeleniumUtils.switchToWindowAndVerifyTitle(getDriver(), extentManager);
        Assert.assertEquals(actualTitle, "The Weather Channel - Home");
    }


}
/*
3. close pop-up window
4. Click on following buttons in the bottom of the page:
    facebook
    twitter
    youtube
5. Print out titles of all 3 pages opened above
6. Close 3 windows and return to weather channel window
 */