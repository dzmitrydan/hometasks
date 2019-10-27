package googlecloud.page;

import googlecloud.wait.LoadPageConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingPage extends AbstractPage {

    public PricingPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath ="//*[@id='cloud-site']/nav/div/div/ul/li[3]/a")
    private WebElement navMenuCalculators;

    public PricingCalculatorPage openPricingCalculatorPage(){
        navMenuCalculators.click();
        wait.until(LoadPageConditions.jQueryAJAXsCompleted());
        return new PricingCalculatorPage(driver);
    }
}
