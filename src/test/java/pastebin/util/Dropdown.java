package pastebin.util;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Dropdown {

    public static void selectHiddenItemByText(String dropdownItemText, WebElement select, Actions builder, WebDriver driver) {
        List<WebElement> options = select.findElements(By.tagName("option"));

        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getAttribute("disabled") != null) {
                options.remove(i);
            }
        }

        for (WebElement option : options) {
            if (dropdownItemText.equals(option.getAttribute("innerHTML").trim())) {
                if (options.indexOf(option) == 0) {
                    builder.sendKeys(select, Keys.ENTER).perform();
                } else if (options.indexOf(option) == 1) {
                    builder.sendKeys(select, Keys.ARROW_DOWN).perform();
                    builder.sendKeys(Keys.ENTER).perform();
                } else {
                    builder.sendKeys(select, Keys.ARROW_DOWN).perform();
                    for (int i = 2; i < options.indexOf(option) + 1; i++) {
                        builder.sendKeys(Keys.ARROW_DOWN).perform();
                    }
                    builder.sendKeys(Keys.ENTER).perform();
                }
                break;
            }
        }
    }

}
