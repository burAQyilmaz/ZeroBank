package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.*;
import com.zeroBank.utility.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigation_SD {
    LoginPage loginPage = new LoginPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        loginPage.loggedIn();
    }

    @Given("clicks on {string} link")
    public void clicks_on_link(String linkText) {
        accountActivityPage.clickLinkFromWebElementList(linkText);
    }

    @Then("the Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Activity"));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {
        Select select = new Select(accountActivityPage.dropDownSelectedOption);
        Assert.assertEquals(option, select.getFirstSelectedOption().getText());
    }
}
