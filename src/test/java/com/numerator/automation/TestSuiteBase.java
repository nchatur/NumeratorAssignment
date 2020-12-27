package com.numerator.automation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestSuiteBase {

    protected final static Logger log = LoggerFactory.getLogger(TestSuiteBase.class);
    protected String userName = "y_test_nitin@yahoo.com";
    protected String password = "Asimil89#";
    protected String browser = "firefox";

    /**
     * Base class implementation of Test Suite.
     *
     * @author Nitin Chaturvedi
     */
    public TestSuiteBase(){
        Properties props = readPropertiesFile();
        userName = (String) props.get("userName");
        password = (String) props.get("password");
        browser = (String) props.get("browser");
    }


    public static Properties readPropertiesFile() {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\resources\\QAEnv.properties");
            // create Properties class object
            prop = new Properties();
            // load properties file into it
            prop.load(fis);

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return prop;
    }

}
