Steps to execute tests.
1. Open QAEnv.properties file under resources folder and update the browser and user details.
2. Open a command line at the project level and run,
        mvn clean install
3. After the test execution completed, run the allure report by following these steps,
    i. cd to target folder. There should be a folder named "allure-results"
    ii. run the command "allure serve" . This command will create results in temporary folder and show the results in
       the browser window.
