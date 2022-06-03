package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopupPage extends BasePage {
    protected WebDriver driver;

    public PopupPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@class='PrivacyDataNotice--mainParagraph--1nQsp']")
    public static WebElement messagePopup;

    @FindBy(xpath = "//*[@class='Icon--icon--3wCKh Icon--actionTheme--sZu_q PrivacyDataNotice--closeButton--1fBzh']")
    public static WebElement xBtn;

    @FindBy(xpath = "//h2[@class='PrivacyDataNotice--heading--2VTdU']")
    public WebElement popUpText;

    @FindBy(name = "close")
    public WebElement closePopUpBtn;

    @FindBy(xpath = "//span[@class='Footer--connect--x2PKn']")
    public WebElement footer;

    @FindBy(xpath = "//div[@class='Footer--socialLogos--2MwDy']//a")
    public WebElement facebookBtn;

    @FindBy(name = "twitter")
    public WebElement twitterBtn;

    @FindBy(name = "youtube")
    public WebElement youtubeBtn;
}
