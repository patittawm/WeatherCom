package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FollowingPage;
import pages.WeatherPage;

public class WeatherDayTest extends BaseTest {
    FollowingPage homePage;
    WeatherPage weatherPage;

    @BeforeMethod
    public void localSetUp(){

        homePage = new FollowingPage(getDriver());
        weatherPage = new WeatherPage(getDriver());
    }

    @Test(testName = "10 Day")
    public void test7(){

        //Click 10Day
        getDriver().findElement(By.xpath("//span[text()='10 Day']")).click();
        FollowingPage WeatherPage;
        for (int i = 1; i < weatherPage.dayList.size(); i++) {
            String eachDay = weatherPage.dayList.get(i).getText();
            String eachTemp = weatherPage.tempList.get(i).getText().replace("\n", "");
            String eachDescr = weatherPage.descrList.get(i).getText();
            System.out.println(eachDay + " - " + eachTemp + " - " + eachDescr);
        }
    }
}

/*
7. Click to "10 Day" button and print out following:
    Day - High/Low - Description
    Today - 92/73 - Scattered Thunderstorms
 */