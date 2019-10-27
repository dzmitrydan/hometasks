package googlecloud.page;

import googlecloud.wait.LoadPageConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudHomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com";

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(partialLinkText = "See all 100+ products")
    private WebElement linkSeeAllProducts;

    public GoogleCloudHomePage openHomePage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(LoadPageConditions.jQueryAJAXsCompleted());
        return this;
    }

    public ProductsAndServicesPage openProductsAndServicesPage(){
        executor.executeScript("arguments[0].scrollIntoView(true);", linkSeeAllProducts);
        executor.executeScript("arguments[0].click();", linkSeeAllProducts);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        wait.until(LoadPageConditions.jQueryAJAXsCompleted());
        return new ProductsAndServicesPage(driver);
    }
}
