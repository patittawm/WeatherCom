import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.SeleniumUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static base.BasePage.switchToNextWindow;
import static utils.SeleniumUtils.scrollIntoView;

public class TempClass {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://weather.com");

    }
    @Test(testName = "Popup")
    public void test123() throws InterruptedException {
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);

        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h2[text()='Your Privacy']"))));
        System.out.println(driver.findElement(By.xpath("//*[@class='PrivacyDataNotice--mainParagraph--1nQsp']")).getText());
        driver.findElement(By.xpath("//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")).click();

    }

    @Test(testName = "Connect Social")
    public void test3456() throws InterruptedException {
        //Close Pop-up
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h2[text()='Your Privacy']"))));
        driver.findElement(By.xpath("//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")).click();

        //scroll down to footer
        scrollIntoView(driver, driver.findElement(By.xpath("//span[@class='Footer--connect--x2PKn']")));
        //Click to FB TW IG YT
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='Footer--connect--x2PKn']"))));

        List<WebElement> links = driver.findElements(By.xpath("//div[@class='Footer--socialLogos--2MwDy']//a"));
        links.forEach(link -> link.click());

        switchToNextWindow(driver);
    }

    @Test(testName = "10 Day")
    public void test7(){
        //Close Pop-up
        WebDriverWait explicitWait = new WebDriverWait(driver, 30);
        explicitWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div//h2[text()='Your Privacy']"))));
        driver.findElement(By.xpath("//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")).click();

        //Click 10Day
        driver.findElement(By.xpath("//span[text()='10 Day']")).click();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
/*
1. Navigate to https://weather.com

2. Wait until pop-up window appears

3. Get the text of the pop-up window and close it

4. Click on following buttons in the bottom of the page:

    facebook

    twitter

    youtube

5. Print out titles of all 3 pages opened above

6. Close 3 windows and return to weather channel window

7. Click to "10 Day" button and print out following:

    Day - High/Low - Description
    Today - 92/73 - Scattered Thunderstorms

 */