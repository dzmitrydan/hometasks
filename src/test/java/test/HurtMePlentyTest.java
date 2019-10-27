package test;

import googlecloud.page.GoogleCloudHomePage;
import googlecloud.page.PricingCalculatorPageComputeEnginePopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HurtMePlentyTest {

    private WebDriver driver;
    private PricingCalculatorPageComputeEnginePopup pricingCalculatorPageComputeEnginePopup;

    @BeforeSuite
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        GoogleCloudHomePage googleCloudHomePage = new GoogleCloudHomePage(driver);
        pricingCalculatorPageComputeEnginePopup = googleCloudHomePage.openHomePage()
                .openProductsAndServicesPage()
                .openPricingPage()
                .openPricingCalculatorPage()
                .goToTabComputeEngine()
                .fillingAndSubmitInstancesForm("4", "");
    }

    @Test
    public void matchingTextVMClassToInputtedInTheForm(){
        String actualVMClassText = pricingCalculatorPageComputeEnginePopup.getVMClass();
        Assert.assertEquals(actualVMClassText, "VM class: regular");
    }

    @Test
    public void matchingTextInstanceTypeToInputtedInTheForm(){
        String actualInstanceTypeText = pricingCalculatorPageComputeEnginePopup.getInstanceType();
        Assert.assertEquals(actualInstanceTypeText, "Instance type: n1-standard-8");
    }

    @Test
    public void matchingTextRegionToInputtedInTheForm(){
        String actualRegionText = pricingCalculatorPageComputeEnginePopup.getRegion();
        Assert.assertEquals(actualRegionText , "Region: Frankfurt");
    }

    @Test
    public void matchingTextLocalSSDToInputtedInTheForm(){
        String actualLocalSSDText = pricingCalculatorPageComputeEnginePopup.getLocalSSD();
        Assert.assertEquals(actualLocalSSDText, "Total available local SSD space 2x375 GB");
    }

    @Test
    public void matchingTextCommitmentTermToInputtedInTheForm(){
        String actualCommitmentTermText = pricingCalculatorPageComputeEnginePopup.getCommitmentTerm();
        Assert.assertEquals(actualCommitmentTermText, "Commitment term: 1 Year");
    }

    @Test
    public void totalEstimatedCostIsMatchingToManualExecutionOfTest(){
        double actualTotalEstimatedCost = pricingCalculatorPageComputeEnginePopup.getTotalEstimatedCostPerMonth();
        double totalEstimatedCostByManuallyExecuting = Double.parseDouble("1,187.77".replace(",", ""));
        Assert.assertEquals(actualTotalEstimatedCost, totalEstimatedCostByManuallyExecuting);
    }

    @AfterSuite
    public void browserClose(){
        driver.quit();
        driver = null;
    }

}
