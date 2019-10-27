package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pastebin.PastePage;
import pastebin.PastebinHomePage;

import java.util.ArrayList;

public class BringItOnTest {

    private WebDriver driver;
    private PastePage pastePage;
    private ArrayList<String> textNewPaste;
    private String textSyntaxHighlighting = "Bash";
    private String textPasteExpiration = "10 Minutes";
    private String textPasteNameTitle = "how to gain dominance among developers";

    @BeforeSuite
    public void browserSetup(){

        textNewPaste = new ArrayList<>();
        textNewPaste.add("git config --global user.name  \"New Sheriff in Town\"");
        textNewPaste.add("git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")");
        textNewPaste.add("git push origin master --force");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage
                .openPage()
                .fillingForm(textNewPaste, textSyntaxHighlighting, textPasteExpiration, textPasteNameTitle);
        pastePage = pastebinHomePage.createNewPaste();
    }

    @Test
    public void textOfTitlePageMatchesPasteNameTitle(){
        String actualTextOfTitlePage = pastePage.getTitleBrowserPage();
        Assert.assertEquals(actualTextOfTitlePage, textPasteNameTitle);
    }

    @Test
    public void syntaxHighlightingIsCorrect(){
        String actualSyntaxHighlighting = pastePage.getSyntaxHighlighting();
        Assert.assertEquals(actualSyntaxHighlighting, textSyntaxHighlighting);
    }

    @Test
    public void pasteCodeIsCorrect(){
        ArrayList<String> actualPasteCode = pastePage.getPasteCode();
        Assert.assertEquals(actualPasteCode, textNewPaste);
    }


    @AfterSuite
    public void browserClose(){
        driver.quit();
        driver = null;
    }
}
