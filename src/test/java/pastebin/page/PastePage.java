package pastebin.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class PastePage {

    private final WebDriver driver;

    @FindBy(tagName = "h1")
    private WebElement titleBrowserPage;

    @FindBy(xpath = "//a[@class = 'btn -small h_800']")
    private WebElement syntaxHighlighting;

    @FindBy(xpath = "//textarea[@class='textarea']")
    private WebElement textareaPasteCode;

    public PastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitleBrowserPage() {
        return titleBrowserPage.getText();
    }

    public String getSyntaxHighlighting() {
        return syntaxHighlighting.getText();
    }

    public ArrayList<String> getPasteCode() {
        String pasteCode = textareaPasteCode.getText();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(pasteCode.split("\n")));
        return arrayList;
    }

}
