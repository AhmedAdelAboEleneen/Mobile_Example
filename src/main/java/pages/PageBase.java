package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {
    AppiumDriver<WebElement> driver;

    // create constructor
    public PageBase(AppiumDriver<WebElement> driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

        this.driver = driver;

    }

    // function for clicks
    protected static void clickBt(WebElement button) {

        button.click();
    }

    // function for set text in filed
    protected static void setTxtElment(WebElement textElement, String value) {


        textElement.sendKeys(value);
    }
}
