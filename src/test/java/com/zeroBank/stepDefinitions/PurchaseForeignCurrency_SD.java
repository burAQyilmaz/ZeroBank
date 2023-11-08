package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.utility.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrency_SD {

    PayBillsPage payBillsPage = new PayBillsPage();
    Select select;

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        select = new Select(payBillsPage.currencyDropDown);

        List<String> currenciesList = BrowserUtils.getStringListFromWebElementList(select.getOptions());

        Assert.assertTrue(currenciesList.containsAll(dataTable));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        payBillsPage.inputAmount.sendKeys("1000");
        payBillsPage.radioButtonDollar.click();
        payBillsPage.calculateButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        BrowserUtils.waitUntilAlertIsPresent(5);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        select = new Select(payBillsPage.currencyDropDown);

        select.selectByVisibleText("New Zealand (dollar)");
        payBillsPage.radioButtonDollar.click();
        payBillsPage.calculateButton.click();
    }
}
