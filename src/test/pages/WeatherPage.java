package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WeatherPage extends BasePage {
    public WeatherPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-testid='DetailsSummary']/h3[contains (@data-testid,'')]")
    public List<WebElement> dayList;

    @FindBy (xpath = "//div[@data-testid='DetailsSummary']/div[@data-testid='detailsTemperature']")
    public List <WebElement> tempList;

    @FindBy (xpath = "//div[@data-testid='DetailsSummary']//span[@class='DetailsSummary--extendedData--365A_']")
    public List <WebElement> descrList;
}
