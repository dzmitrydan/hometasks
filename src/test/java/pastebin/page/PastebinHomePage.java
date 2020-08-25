package pastebin.page;

import pastebin.util.Dropdown;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;


public class PastebinHomePage {

    private static final String HOMEPAGE_URL = "https://pastebin.com";
    private static final int WAIT_TIMEOUT_SECONDS = 10;
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions builder;

    private final By formPasteLocator = By.tagName("form");
    private final By successMessage = By.xpath("//div[@class='notice -success -post-view']");

    @FindBy(id = "postform-text")
    private WebElement textareaNewPaste;

    @FindBy(css = "select[name='PostForm[format]']")
    private WebElement selectSyntaxHighlighting;

    @FindBy(css = "select[name='PostForm[expiration]']")
    private WebElement selectPasteExpiration;

    @FindBy(css = "input[name='PostForm[name]']")
    private WebElement inputPasteNameTitle;

    @FindBy(css = "button.btn")
    private WebElement buttonCreateNewPaste;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS);
        builder = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(formPasteLocator));
        return this;
    }

    public PastebinHomePage fillingForm(
            String textNewPaste,
            String textPasteExpiration,
            String textPasteNameTitle) {

        textareaNewPaste.sendKeys(textNewPaste);
        Dropdown.selectHiddenItemByText(textPasteExpiration, selectPasteExpiration, builder, driver);
        inputPasteNameTitle.sendKeys(textPasteNameTitle);
        return this;
    }

    public PastebinHomePage fillingForm(
            ArrayList<String> textNewPaste,
            String textSyntaxHighlighting,
            String textPasteExpiration,
            String textPasteNameTitle) {

        for (String string : textNewPaste) {
            textareaNewPaste.sendKeys(string);
            textareaNewPaste.sendKeys(Keys.ENTER);
        }

        Dropdown.selectHiddenItemByText(textSyntaxHighlighting, selectSyntaxHighlighting, builder, driver);
        Dropdown.selectHiddenItemByText(textPasteExpiration, selectPasteExpiration, builder, driver);
        inputPasteNameTitle.sendKeys(textPasteNameTitle);
        return this;
    }

    public PastePage createNewPaste() {
        buttonCreateNewPaste.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return new PastePage(driver);
    }

}
