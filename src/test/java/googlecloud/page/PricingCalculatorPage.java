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

    private final NgWebDriver ngDriver;

    @FindBy(xpath = "//iframe[contains(@name, 'goog')]")
    private WebElement frame;

    @FindBy(id = "myFrame")
    private WebElement frameMyFrame;

    @FindBy(xpath = "//*[contains(@title, 'Compute Engine')]")
    private WebElement tabComputeEngine;

    @FindBy(name = "quantity")
    private WebElement inputNumberOfInstances;

    @ByAngularModel.FindBy(model = "listingCtrl.computeServer.label")
    private WebElement inputWhatAreTheseInstancesFor;

    @FindBy(xpath = "//div[contains(text(), 'Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS')]")
    private WebElement dropdownOperatingSystemSoftwareFree;

    @FindBy(xpath = "//div[contains(text(), 'Regular')]")
    private WebElement dropdownMachineClassRegular;

    @FindBy(xpath = "//div[contains(text(), 'n1-standard-8 (vCPUs: 8, RAM: 30GB)')]")
    private WebElement dropdownMachineTypeN1standard8;

    @ByAngularModel.FindBy(model = "listingCtrl.computeServer.addGPUs")
    private WebElement checkboxAddGPUs;

    @FindBy(xpath = "//div[contains(text(), '1')]")
    private WebElement dropdownNumberOfGPUs1;

    @FindBy(xpath = "//div[contains(text(), 'NVIDIA Tesla V100')]")
    private WebElement dropdownGPUTypeNVIDIATeslaV100;

    @FindBy(xpath = "//div[contains(text(), '2x375 GB')]")
    private WebElement dropdownLocalSSD2x375Gb;

    @FindBy(xpath = "//div[contains(text(), 'Frankfurt (europe-west3)')]")
    private WebElement dropdownDatacenterLocationFrankfurt;

    @FindBy(xpath = "//div[contains(text(), '1 Year')]")
    private WebElement dropdownCommitedUsage1Year;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Add to Estimate")
    private WebElement buttonAddToEstimate;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameMyFrame));
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
    }

    public PricingCalculatorPage goToTabComputeEngine() {
        executor.executeScript("arguments[0].click();", tabComputeEngine);
        return this;
    }

    public PricingCalculatorPageComputeEnginePopup fillingAndSubmitInstancesForm(String textNumberOfInstances, String textWhatAreTheseInstancesFor) {

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
