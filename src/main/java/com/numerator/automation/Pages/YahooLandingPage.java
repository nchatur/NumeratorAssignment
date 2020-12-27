package com.numerator.automation.Pages;

import com.numerator.automation.Utils.WebdriverUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Page object implementation of the Yahoo mail landing page
 *
 * @author Nitin Chaturvedi
 */
public class YahooLandingPage extends Page {

    private final static String INPUT_USER_CSS = "input[name=\"username\"]";
    private final static String INPUT_PASSWORD_CSS = "input[name=\"password\"]";
    private final static String INPUT_NEXT_CSS = "input[name=\"signin\"]";
    private final static String BUTTON_LOGIN_CSS = "button[name=\"verifyPassword\"]";
    private final static String SIGN_IN_CSS = ".fuji-button-text > span:nth-child(1)";
    private final static String DIV_MAIL_BOX_PAGE_CSS= "._yb_1mnr5";
    private final static String P_PASSWORD_ERROR_CSS = "p[data-error=\"messages.ERROR_INVALID_PASSWORD\"]" ;

    protected String baseUrl = "https://mail.yahoo.com";
    public YahooLandingPage(String browser) {
        super(browser);
        Page.getDriver().get(baseUrl);
        clickSignIn();
    }

    @FindBy(css=SIGN_IN_CSS)
    private WebElement signIn;
    public YahooLandingPage clickSignIn(){
        log.info("clicking Sign In");
        signIn.click();
        WebdriverUtils.waitForPageLoaded(driver);
        return this;
    }

    @FindBy(css = INPUT_USER_CSS)
    private WebElement userNameField;
    public YahooLandingPage enterUserName(String userName){
        log.info("entering user name");
        WebdriverUtils.waitForPageLoaded(driver);
        WebdriverUtils.waitForElementToBeClickable(driver, userNameField);
        userNameField.clear();
        userNameField.sendKeys(userName);
        return this;
    }

    @FindBy(css = INPUT_PASSWORD_CSS)
    private WebElement passwordField;
    public YahooLandingPage enterPassword(String password){
        log.info("entering password");
        WebdriverUtils.waitForPageLoaded(driver);
        WebdriverUtils.waitForElementToBeClickable(driver, passwordField);
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @FindBy(css = INPUT_NEXT_CSS)
    private WebElement nextButton;
    public YahooLandingPage clickNext(){
        log.info("clicking next button");
        WebdriverUtils.waitForPageLoaded(driver);
        WebdriverUtils.waitForElementToBeClickable(driver, nextButton);
        nextButton.click();
        return this;
    }

    @FindBy(css = BUTTON_LOGIN_CSS)
    private WebElement loginButton;
    public YahooLandingPage clickLogin(){
        log.info("clicking login button");
        WebdriverUtils.waitForPageLoaded(driver);
        WebdriverUtils.waitForElementToBeClickable(driver, loginButton);
        loginButton.click();
        return this;
    }

    @FindBy(css = DIV_MAIL_BOX_PAGE_CSS)
    private WebElement loginPageDiv;
    public boolean isLoginPageLoaded(){
        WebdriverUtils.waitForPageLoaded(driver);
        return loginPageDiv.isDisplayed();
    }

    @FindBy(css =P_PASSWORD_ERROR_CSS)
    private WebElement passwordError;
    public boolean isPasswordErrorShown(){
        WebdriverUtils.waitForPageLoaded(driver);
        return passwordError.isDisplayed();
    }

    public void tearDown(){
        driver.quit();
    }

}
