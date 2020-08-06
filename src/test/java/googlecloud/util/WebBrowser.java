package googlecloud.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class WebBrowser {

    private static ArrayList<String> webBrowserTabList;

    public static WebDriver openNewWebBrowserTab(WebDriver driver) {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        webBrowserTabList = new ArrayList<>(driver.getWindowHandles());
        return driver.switchTo().window(webBrowserTabList.get(1));
    }

    public static WebDriver openExistingWebBrowserTab(WebDriver driver, String webBrowserTab) {
        return driver.switchTo().window(webBrowserTab);
    }

}
