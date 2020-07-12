package googlecloud.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@href='/pricing']")
    private WebElement tabPrising;

    @FindBy(xpath = "//a[@href='/products/calculator']")
    private WebElement dropdownItemCalculators;

    public GoogleCloudHomePage openHomePage(){
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.elementToBeClickable(tabPrising));
        return this;
    }

    public PricingCalculatorPage openPricingCalculatorPage(){
        tabPrising.click();
        wait.until(ExpectedConditions.elementToBeClickable(dropdownItemCalculators));
        dropdownItemCalculators.click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        return new PricingCalculatorPage(driver);
    }
}
