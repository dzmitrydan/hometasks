package googlecloud.page;

import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.ByAngularPartialButtonText;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailYourEstimatePopup extends AbstractPage {

    private NgWebDriver ngDriver;
    private String webBrowserTab;


    protected EmailYourEstimatePopup(WebDriver driver) {
        super(driver);
        ngDriver = new NgWebDriver((JavascriptExecutor) driver);
        ngDriver.waitForAngularRequestsToFinish();
        webBrowserTab = driver.getWindowHandle();
    }


    @ByAngularModel.FindBy(model = "emailQuote.user.email")
    private WebElement inputEmail;

    @ByAngularPartialButtonText.FindBy(partialButtonText = "Send Email")
    private WebElement buttonSendEmail;


    public void fillingAndSubmitEmailYourEstimateForm(String email){
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        inputEmail.sendKeys(email);
        executor.executeScript("arguments[0].click();", buttonSendEmail);
    }

    public String getWebBrowserTab() {
        return webBrowserTab;
    }


}
