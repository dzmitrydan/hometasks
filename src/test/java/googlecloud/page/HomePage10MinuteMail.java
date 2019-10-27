package googlecloud.page;

import googlecloud.wait.LoadPageConditions;
import org.openqa.selenium.By;
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


    @FindBy(id = "mailAddress")
    private WebElement fieldMailAddress;

    @FindBy(id = "messagesList")
    private WebElement messagesList;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/h2")
    private WebElement totalEstimatedMonthlyCost;


    public HomePage10MinuteMail openHomePage10MinuteMail(){
        driver.get(HOMEPAGE_URL);

        wait.until(LoadPageConditions.jQueryAJAXsCompleted());
        return this;
    }

    public String getMailAddress(){
        executor.executeScript("arguments[0].scrollIntoView(true);", fieldMailAddress);
        return fieldMailAddress.getAttribute("value");
    }

    public double getTotalEstimatedMonthlyCost(){
        waitMessage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS_FOR_MESSAGE);
        waitMessage.until(ExpectedConditions.visibilityOf(messagesList));

        WebElement messageFromGoogleCloudPlatform = messagesList.findElement(By.xpath(".//h3/span[text()='Google Cloud Platform Price Estimate']"));
        messageFromGoogleCloudPlatform.click();

        executor.executeScript("arguments[0].scrollIntoView(true);", totalEstimatedMonthlyCost);

        String stringTotalEstimatedMonthlyCost = totalEstimatedMonthlyCost.getText();
        stringTotalEstimatedMonthlyCost = stringTotalEstimatedMonthlyCost.replaceAll("[^0-9.]", "");

        return Double.parseDouble(stringTotalEstimatedMonthlyCost);
    }




}
