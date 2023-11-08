package com.zeroBank.stepDefinitions;

import com.zeroBank.utility.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    @Before(order = 1)
    public void setupScenario() {

    }

    @Before (value = "@login", order = 2)
    public void setupScenarioForLogins() {

    }

    @Before (value = "@db", order = 0)
    public void setupForDatabaseScenarios() {

    }


    @After
    public void teardownScenario(Scenario scenario) {

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value


        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }


        //BrowserUtils.sleep(5);
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

    @BeforeStep
    public void setupStep() {

    }

    @AfterStep
    public void afterStep() {

    }

}
