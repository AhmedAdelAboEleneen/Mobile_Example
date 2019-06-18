package test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utilities.Helper;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void startDriver() throws MalformedURLException {

        DesiredCapabilities object = new DesiredCapabilities();

        object.setCapability("platformName", "Android");

        object.setCapability("platformVersion", "6.0.1");

        object.setCapability("deviceName", "Android Emulator");

        object.setCapability("appPackage", "");

        object.setCapability("appActivity", "");

        driver = new AndroidDriver<WebElement>(new URL("http://localhost:4723/wd/hub"), object);

    }

    @AfterSuite
    public void stopDriver() {

        driver.quit();
    }

    //Take Screenshot when test case fail and add it in screenshot folder
    @AfterMethod
    public void screenShootsOnFailure(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Failed!");
            System.out.println("Taking ScreenShot.......");
            Helper.caputreScreenShoot(driver, result.getName());

        }

    }
}
