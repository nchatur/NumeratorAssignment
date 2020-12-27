package com.numerator.automation.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Driver Factory implementation of generic methods related to Web Driver
 *
 * @author Nitin Chaturvedi
 */
public class DriverFactory {

    private final static Logger log = LoggerFactory.getLogger(DriverFactory.class);

    private static final int StandardTimeIntervalSec = 10;

    private static String pathToDriver = System.getProperty("user.dir") + "\\src\\drivers";

    private static WebDriver driver;

    public static void setDriver(String browser) {
        if (browser.equals("firefox")) {
            log.info("setting driver instance specifically for firefox");
            System.setProperty("webdriver.gecko.driver", pathToDriver + "\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equals("chrome")) {
            log.info("setting driver instance specifically for chrome");
            System.setProperty("webdriver.chrome.driver", pathToDriver + "\\chromedriver.exe");
            driver = new ChromeDriver();
        }
    }

    public static synchronized WebDriverWait getWait(WebDriver driver) {
        return new WebDriverWait(driver, StandardTimeIntervalSec * 2);
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
