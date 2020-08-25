package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pastebin.page.PastebinHomePage;


public class ICanWin {

    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    protected void openingAndFillingPastebinHomePageData() {

        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage
                .openPage()
                .fillingForm("Hello from WebDriver", "10 Minutes", "helloweb");
    }

    @AfterTest(alwaysRun = true)
    public void browserClose() {
        driver.quit();
        driver = null;
    }

}
