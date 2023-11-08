package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.BasePage;
import com.zeroBank.pages.LoginPage;
import com.zeroBank.utility.BrowserUtils;
import com.zeroBank.utility.ConfigurationReader;
import com.zeroBank.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class Login_SD {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("login"));
    }

    @When("user types valid credentials")
    public void user_types_valid_credentials() {
        loginPage.userNameInput.sendKeys(ConfigurationReader.getProperty("userName"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
    }

    @When("user clicks sign in buttons")
    public void user_clicks_sign_in_buttons() {
        loginPage.signInButton.click();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        Driver.getDriver().navigate().back();
        BrowserUtils.waitForVisibility(basePage.userNameTag, 10);
        Assert.assertTrue(basePage.userNameTag.getText().contains(ConfigurationReader.getProperty("userName")));

    }

    @When("user types the {string} as username and {string} as password")
    public void user_types_the_as_username_and_as_password(String invalidUserName, String invalidPassword) {
        loginPage.userNameInput.sendKeys(invalidUserName);
        loginPage.passwordInput.sendKeys(invalidPassword);
    }

    @Then("user sees error message {string}")
    public void user_sees_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPage.errorMessage.getText());
    }
}
