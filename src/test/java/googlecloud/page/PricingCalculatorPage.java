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
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("myFrame")));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
    }


    @FindBy(xpath ="//*[@id='mainForm']/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]")
    private WebElement tabComputeEngine;

    @FindBy(id = "input_61")
    private WebElement inputNumberOfInstances;

    @FindBy(id = "input_62")
    private WebElement inputWhatAreTheseInstancesFor;

    @FindBy(id = "select_option_63")
    private WebElement dropdownOperatingSystemSoftwareFree;

    @FindBy(id = "select_option_75")
    private WebElement dropdownMachineClassRegular;

    @FindBy(id ="select_option_228")
    private WebElement dropdownMachineTypeN1standard8;

    @ByAngularModel.FindBy(model = "listingCtrl.computeServer.addGPUs")
    private WebElement checkboxAddGPUs;

    @FindBy(id ="select_option_357")
    private WebElement dropdownNumberOfGPUs1;

    @FindBy(xpath ="//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement dropdownGPUTypeNVIDIATeslaV100;

    @FindBy(id ="select_option_249")
    private WebElement dropdownLocalSSD2x375Gb;

    @FindBy(id ="select_option_196")
    private WebElement dropdownDatacenterLocationFrankfurt;

    @FindBy(id ="select_option_93")
    private WebElement dropdownCommitedUsage1Year;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Add to Estimate")
    private WebElement buttonAddToEstimate;


    public PricingCalculatorPage goToTabComputeEngine(){
        executor.executeScript("arguments[0].click();", tabComputeEngine);
        return this;
    }

    public PricingCalculatorPageComputeEnginePopup fillingAndSubmitInstancesForm(String textNumberOfInstances, String textWhatAreTheseInstancesFor){

        inputNumberOfInstances.sendKeys(textNumberOfInstances);

        inputWhatAreTheseInstancesFor.sendKeys(textWhatAreTheseInstancesFor);

        executor.executeScript("arguments[0].click();", dropdownOperatingSystemSoftwareFree);
        executor.executeScript("arguments[0].click();", dropdownOperatingSystemSoftwareFree);

        executor.executeScript("arguments[0].click();", dropdownMachineClassRegular);
        executor.executeScript("arguments[0].click();", dropdownMachineClassRegular);

        executor.executeScript("arguments[0].click();", dropdownMachineTypeN1standard8);
        executor.executeScript("arguments[0].click();", dropdownMachineTypeN1standard8);

        executor.executeScript("arguments[0].click();", checkboxAddGPUs);

        executor.executeScript("arguments[0].click();", dropdownNumberOfGPUs1);
        executor.executeScript("arguments[0].click();", dropdownNumberOfGPUs1);

        executor.executeScript("arguments[0].click();", dropdownGPUTypeNVIDIATeslaV100);
        executor.executeScript("arguments[0].click();", dropdownGPUTypeNVIDIATeslaV100);

        executor.executeScript("arguments[0].click();", dropdownLocalSSD2x375Gb);
        executor.executeScript("arguments[0].click();", dropdownLocalSSD2x375Gb);

        executor.executeScript("arguments[0].click();", dropdownDatacenterLocationFrankfurt);
        executor.executeScript("arguments[0].click();", dropdownDatacenterLocationFrankfurt);

        executor.executeScript("arguments[0].click();", dropdownCommitedUsage1Year);
        executor.executeScript("arguments[0].click();", dropdownCommitedUsage1Year);

        buttonAddToEstimate.submit();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("compute"), "Compute Engine"));

        return new PricingCalculatorPageComputeEnginePopup(driver);
    }


}
