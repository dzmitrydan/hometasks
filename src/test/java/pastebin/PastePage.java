package pastebin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;

public class PastePage {

    private WebDriver driver;

    public PastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h1")
    private WebElement titleBrowserPage;

    @FindBy(xpath = "//*[@id='code_buttons']/span[2]/a")
    private WebElement syntaxHighlighting;

    @FindBy(id = "paste_code")
    private WebElement textareaPasteCode;


    public String getTitleBrowserPage(){
        return titleBrowserPage.getText();
    }

    public String getSyntaxHighlighting(){
        return syntaxHighlighting.getText();
    }

    public ArrayList<String> getPasteCode(){
        String pasteCode = textareaPasteCode.getText();
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(pasteCode.split("\n")));
        return arrayList;
    }
}
