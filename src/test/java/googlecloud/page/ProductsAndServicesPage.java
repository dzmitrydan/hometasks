package googlecloud.page;

import googlecloud.wait.LoadPageConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsAndServicesPage extends AbstractPage {

    public ProductsAndServicesPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath ="//*[@id='google-cloud-platform']/div[1]/section/div[3]/a[2]")
    private WebElement buttonSeePricing;

    public PricingPage openPricingPage(){
        buttonSeePricing.click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(LoadPageConditions.jQueryAJAXsCompleted());
        return new PricingPage(driver);
    }



}
