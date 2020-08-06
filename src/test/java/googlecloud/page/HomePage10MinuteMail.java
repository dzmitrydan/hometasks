package googlecloud.page;

import googlecloud.util.DataTypeConverter;
import googlecloud.wait.LoadPageConditions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage10MinuteMail extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://10minutemail.com";
    private static final int WAIT_TIMEOUT_SECONDS_FOR_MESSAGE = 60;
    private WebDriverWait waitMessage;

    public HomePage10MinuteMail(WebDriver driver) {
        super(driver);
    }
    private String webBrowserTab;

    @FindBy(id = "mail_address")
    private WebElement fieldMailAddress;

    @FindBy(xpath = "//*[@id='mail_messages_content']/div[1]/div[1]/div[3]/span[text()='Google Cloud Platform Price Estimate']")
    private WebElement messageFromGoogleCloud;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/table/tbody/tr[2]/td[2]/h3")
    private WebElement totalEstimatedMonthlyCost;


    public HomePage10MinuteMail openHomePage10MinuteMail(){
        driver.get(HOMEPAGE_URL);

        wait.until(LoadPageConditions.jQueryAJAXsCompleted());
        webBrowserTab = driver.getWindowHandle();
        return this;
    }

    public String getMailAddress(){
        executor.executeScript("arguments[0].scrollIntoView(true);", fieldMailAddress);
        return fieldMailAddress.getAttribute("value");
    }

    public double getTotalEstimatedMonthlyCost(){
        waitMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS_FOR_MESSAGE);
        waitMessage.until(ExpectedConditions.visibilityOf(messageFromGoogleCloud)).click();

        executor.executeScript("arguments[0].scrollIntoView(true);", totalEstimatedMonthlyCost);

        String stringTotalEstimatedMonthlyCost = totalEstimatedMonthlyCost.getText();

        return DataTypeConverter.stringToDouble(stringTotalEstimatedMonthlyCost);
    }

    public String getWebBrowserTab() {
        return webBrowserTab;
    }

}
