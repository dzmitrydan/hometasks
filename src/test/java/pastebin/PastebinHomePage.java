package pastebin;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;


public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    private By successMessage = By.id("success");
    private By formPasteLocator = By.id("myform");

    @FindBy(id = "paste_code")
    private WebElement textareaNewPaste;

    @FindBy(css = "select[name='paste_format']")
    private WebElement selectSyntaxHighlighting;

    @FindBy(css = "select[name='paste_expire_date']")
    private WebElement selectPasteExpiration;

    @FindBy(css = "input[name='paste_name']")
    private WebElement inputPasteNameTitle;

    @FindBy(id = "submit")
    private WebElement buttonCreateNewPaste;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(formPasteLocator));
        return this;
    }

    public PastebinHomePage fillingForm(
            String textNewPaste,
            String textPasteExpiration,
            String textPasteNameTitle){

        textareaNewPaste.sendKeys(textNewPaste);
        new Select(selectPasteExpiration).selectByVisibleText(textPasteExpiration);
        inputPasteNameTitle.sendKeys(textPasteNameTitle);
        return this;
    }

    public PastebinHomePage fillingForm(
            ArrayList<String> textNewPaste,
            String textSyntaxHighlighting,
            String textPasteExpiration,
            String textPasteNameTitle){

        for (String string : textNewPaste){
            textareaNewPaste.sendKeys(string);
            textareaNewPaste.sendKeys(Keys.ENTER);
        }

        new Select(selectSyntaxHighlighting).selectByVisibleText(textSyntaxHighlighting);
        new Select(selectPasteExpiration).selectByVisibleText(textPasteExpiration);
        inputPasteNameTitle.sendKeys(textPasteNameTitle);
        return this;
    }

    public PastePage createNewPaste(){
        buttonCreateNewPaste.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return new PastePage(driver);
    }
}
