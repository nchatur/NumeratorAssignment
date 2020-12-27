package com.numerator.automation.Pages;

import com.numerator.automation.Utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Abstract page class to provide generic functionality of a web page.
 *
 * @author Nitin Chaturvedi
 */
public abstract class Page {

    protected static WebDriver driver;
    private final static int STANDARD_TIME_INTERVAL_SEC = 10;

    protected final static Logger log = LoggerFactory.getLogger(Page.class);


    public Page(String browser) {
        DriverFactory.setDriver(browser);
        this.driver = DriverFactory.getDriver();
        driver.manage().timeouts().implicitlyWait(STANDARD_TIME_INTERVAL_SEC, SECONDS);
        PageFactory.initElements(driver, this);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public abstract void tearDown();
}
