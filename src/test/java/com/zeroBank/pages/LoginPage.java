package com.zeroBank.pages;

import com.zeroBank.utility.BrowserUtils;
import com.zeroBank.utility.ConfigurationReader;
import com.zeroBank.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user_login")
    public WebElement userNameInput;

    @FindBy(id = "user_password")
    public WebElement passwordInput;

    @FindBy(css = "input[value='Sign in']")
    public WebElement signInButton;

    @FindBy(css = ".alert-error")
    public WebElement errorMessage;

    BasePage basePage = new BasePage();
    public void loggedIn() {

        Driver.getDriver().get(ConfigurationReader.getProperty("login"));
        userNameInput.sendKeys(ConfigurationReader.getProperty("userName"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        signInButton.click();
        Driver.getDriver().navigate().back();
        BrowserUtils.waitForVisibility(basePage.userNameTag, 10);
        System.out.println("basePage.userNameTag = " + basePage.userNameTag);
        Assert.assertTrue(basePage.userNameTag.getText().contains(ConfigurationReader.getProperty("userName")));
    }
}
