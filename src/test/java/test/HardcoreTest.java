package test;

import googlecloud.page.*;
import googlecloud.util.WebBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class HardcoreTest {

    private WebDriver driver;
    private PricingCalculatorPageComputeEnginePopup pricingCalculatorPageComputeEnginePopup;


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

        WebBrowser.openNewWebBrowserTab(driver);

        HomePage10MinuteMail homePage10MinuteMail = new HomePage10MinuteMail(driver);
        homePage10MinuteMail.openHomePage10MinuteMail();
        String mailAddress = homePage10MinuteMail.getMailAddress();

        WebBrowser.openExistingWebBrowserTab(driver, emailYourEstimatePopup.getWebBrowserTab());
        emailYourEstimatePopup.fillingAndSubmitEmailYourEstimateForm(mailAddress);

        WebBrowser.openExistingWebBrowserTab(driver, homePage10MinuteMail.getWebBrowserTab());
        double actualTotalEstimatedMonthlyCostInEmail = homePage10MinuteMail.getTotalEstimatedMonthlyCost();

        Assert.assertEquals(actualTotalEstimatedMonthlyCostInEmail, totalEstimatedCostTextOnPricingCalculatorPage);
    }

    @AfterSuite
    public void browserClose(){
        driver.quit();
        driver = null;
    }

}
