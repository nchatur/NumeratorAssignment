package com.numerator.automation.functional;

import com.numerator.automation.Pages.YahooLandingPage;
import com.numerator.automation.TestSuiteBase;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

/**
 * Test class for Yahoo Login functionality.
 *
 * @author Nitin Chaturvedi
 */
public class YahooLandingPageTest extends TestSuiteBase {

    private YahooLandingPage yahooPage ;

    @BeforeMethod
    public void startUp(){
        yahooPage  = new YahooLandingPage(browser);
    }

    @AfterMethod
    public void tearDown(){
        yahooPage.tearDown();
    }

    @Title("Google search landing page, Happy Path test Valid User Name , Valid Password")
    @Features("Numerator Assignment")
    @Stories("User opens Yahoo landing page and Login")
    @Test(groups = {"SMOKE.SUITE"})
    public void yahooLoginHappyPath() throws Exception {
        log.info("test yahooLoginHappyPath Started..");
        yahooPage.enterUserName(userName);
        yahooPage.clickNext();
        yahooPage.enterPassword(password);
        yahooPage.clickLogin();
        Assert.assertTrue(yahooPage.isLoginPageLoaded());
        log.info("test yahooLoginHappyPath Completed..");
    }

    @Title("Google search landing page, Valid User Invalid Password")
    @Features("Numerator Assignment")
    @Stories("User opens Yahoo landing page and Login")
    @Test(groups = {"SMOKE.SUITE"})
    public void yahooLoginValidUsernameInvalidPassword() throws Exception {
        log.info("test yahooLoginValidUsernameInvalidPassword Started..");
        yahooPage.enterUserName(userName);
        yahooPage.clickNext();
        yahooPage.enterPassword("invalid");
        yahooPage.clickLogin();
        Assert.assertTrue(yahooPage.isPasswordErrorShown());
        log.info("test yahooLoginValidUsernameInvalidPassword Completed..");
    }

}
