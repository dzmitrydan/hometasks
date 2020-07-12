package test;

import googlecloud.page.EmailYourEstimatePopup;
import googlecloud.page.GoogleCloudHomePage;
import googlecloud.page.HomePage10MinuteMail;
import googlecloud.page.PricingCalculatorPageComputeEnginePopup;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class HardcoreTest {
    private WebDriver driver;
    private PricingCalculatorPageComputeEnginePopup pricingCalculatorPageComputeEnginePopup;
    private ArrayList<String> widowTabs;

    @BeforeSuite
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        pricingCalculatorPageComputeEnginePopup = googleCloudHomePage.openHomePage()
                .openPricingCalculatorPage()
                .goToTabComputeEngine()
                .fillingAndSubmitInstancesForm("4", "");
    }

    @Test
    public void totalEstimatedCostInEmailIsMatchToPricingCalculatorPage(){

        double totalEstimatedCostTextOnPricingCalculatorPage = pricingCalculatorPageComputeEnginePopup.getTotalEstimatedCostPerMonth();

        EmailYourEstimatePopup emailYourEstimatePopup = pricingCalculatorPageComputeEnginePopup.openEmailYourEstimatePopup();
        String tabWindowEmailYourEstimatePopup = driver.getWindowHandle();

        openNewWindowTab();

        HomePage10MinuteMail homePage10MinuteMail = new HomePage10MinuteMail(driver);
        homePage10MinuteMail.openHomePage10MinuteMail();
        String tabWindowHomePage10MinuteMail = driver.getWindowHandle();
        String mailAddress = homePage10MinuteMail.getMailAddress();

        openExistingWindowTab(tabWindowEmailYourEstimatePopup);
        emailYourEstimatePopup.fillingAndSubmitEmailYourEstimateForm(mailAddress);

        openExistingWindowTab(tabWindowHomePage10MinuteMail);
        double actualTotalEstimatedMonthlyCostInEmail = homePage10MinuteMail.getTotalEstimatedMonthlyCost();

        Assert.assertEquals(actualTotalEstimatedMonthlyCostInEmail, totalEstimatedCostTextOnPricingCalculatorPage);
    }

    @AfterSuite
    public void browserClose(){
        driver.quit();
        driver = null;
    }

    private void openNewWindowTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        widowTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(widowTabs.get(1));
    }

    private void openExistingWindowTab(String tabPage) {
        driver.switchTo().window(tabPage);
    }
}
