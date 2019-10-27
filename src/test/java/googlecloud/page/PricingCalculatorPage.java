package googlecloud.page;

import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class PricingCalculatorPage extends AbstractPage {

    private NgWebDriver ngDriver;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("idIframe")));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
    }


    @FindBy(xpath ="//*[@id='mainForm']/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]")
    private WebElement tabComputeEngine;

    @FindBy(id = "input_53")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "input_54")
    private WebElement inputWhatAreTheseInstancesFor;

    @FindBy(id = "select_option_55")
    private WebElement dropdownOperatingSystemSoftwareFree;

    @FindBy(id ="select_option_67")
    private WebElement dropdownMachineClassRegular;

    @FindBy(id ="select_option_217")
    private WebElement dropdownMachineTypeN1standard8;

    @ByAngularModel.FindBy(model = "listingCtrl.computeServer.addGPUs")
    private WebElement checkboxAddGPUs;

    @FindBy(id ="select_option_353")
    private WebElement dropdownNumberOfGPUs1;

    @FindBy(xpath ="//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement dropdownGPUTypeNVIDIATeslaV100;

    @FindBy(id ="select_option_171")
    private WebElement dropdownLocalSSD2x375Gb;

    @FindBy(id ="select_option_185")
    private WebElement dropdownDatacenterLocationFrankfurt;

    @FindBy(id ="select_option_83")
    private WebElement dropdownCommitedUsage1Year;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Add to Estimate")
    private WebElement buttonAddToEstimate;


    public PricingCalculatorPage goToTabComputeEngine(){
        tabComputeEngine.click();
        return this;
    }

    public PricingCalculatorPageComputeEnginePopup fillingAndSubmitInstancesForm(String textNumberOfInstances, String textWhatAreTheseInstancesFor){

        inputNumberOfInstances.sendKeys(textNumberOfInstances);

        inputWhatAreTheseInstancesFor.sendKeys(textWhatAreTheseInstancesFor);

        executor.executeScript("arguments[0].click();", dropdownOperatingSystemSoftwareFree);
        dropdownOperatingSystemSoftwareFree.click();

        executor.executeScript("arguments[0].click();", dropdownMachineClassRegular);
        dropdownMachineClassRegular.click();

        executor.executeScript("arguments[0].click();", dropdownMachineTypeN1standard8);
        dropdownMachineTypeN1standard8.click();

        checkboxAddGPUs.click();

        executor.executeScript("arguments[0].click();", dropdownNumberOfGPUs1);
        dropdownNumberOfGPUs1.click();

        executor.executeScript("arguments[0].click();", dropdownGPUTypeNVIDIATeslaV100);
        dropdownGPUTypeNVIDIATeslaV100.click();

        executor.executeScript("arguments[0].click();", dropdownLocalSSD2x375Gb);
        dropdownLocalSSD2x375Gb.click();

        executor.executeScript("arguments[0].click();", dropdownDatacenterLocationFrankfurt);
        dropdownDatacenterLocationFrankfurt.click();

        executor.executeScript("arguments[0].click();", dropdownCommitedUsage1Year);
        dropdownCommitedUsage1Year.click();

        buttonAddToEstimate.submit();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("compute"), "Compute Engine"));

        return new PricingCalculatorPageComputeEnginePopup(driver);
    }


}
