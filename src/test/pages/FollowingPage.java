package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FollowingPage extends BasePage {

    protected WebDriver driver;

    public FollowingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")
    public static WebElement xBtn;

    @FindBy(name = "close")
    public WebElement closePopUpBtn;

    @FindBy(xpath = "//span[@class='Footer--connect--x2PKn']")
    public WebElement footer;

    @FindBy(xpath = "//div[@class='Footer--socialLogos--2MwDy']//a")
    public WebElement facebook;

    @FindBy(name = "twitter")
    public WebElement twitterBtn;

    @FindBy(name = "youtube")
    public WebElement youtubeBtn;
}
