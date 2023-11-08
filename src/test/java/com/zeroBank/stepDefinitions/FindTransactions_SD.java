package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.*;
import com.zeroBank.utility.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FindTransactions_SD {
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate fromDate;
    LocalDate toDate;

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        accountActivityPage.findTransactionsLink.click();
        Assert.assertTrue(accountActivityPage.headerFindTransactions.isDisplayed());
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        this.fromDate = BrowserUtils.getDateFromString(fromDate, dateTimeFormatter);
        this.toDate = BrowserUtils.getDateFromString(toDate, dateTimeFormatter);

        accountActivityPage.inputFromDate.clear();
        accountActivityPage.inputToDate.clear();

        accountActivityPage.inputFromDate.sendKeys(fromDate);
        accountActivityPage.inputToDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        LocalDate expectedFromDate = BrowserUtils.getDateFromString(fromDate, dateTimeFormatter);
        LocalDate expectedToDate = BrowserUtils.getDateFromString(toDate, dateTimeFormatter);

        for (WebElement listedDate : accountActivityPage.listedDates) {
            LocalDate eachDate = BrowserUtils.getDateFromString(listedDate.getText(), dateTimeFormatter);

            Assert.assertFalse(eachDate.isBefore(expectedFromDate) || eachDate.isAfter(expectedToDate));
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        for (int i = 0; i < accountActivityPage.listedDates.size() - 1; i++) {
            WebElement current = accountActivityPage.listedDates.get(i);
            WebElement next = accountActivityPage.listedDates.get(i + 1);
            Assert.assertTrue(BrowserUtils.getDateFromString(current.getText(), dateTimeFormatter).isAfter(BrowserUtils.getDateFromString(next.getText(), dateTimeFormatter)));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        for (WebElement listedDate : accountActivityPage.listedDates) {
            Assert.assertFalse(listedDate.getText().equalsIgnoreCase(string));
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        accountActivityPage.inputDescription.clear();
        accountActivityPage.inputDescription.sendKeys(string);
        accountActivityPage.findButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        if (accountActivityPage.descriptions.isEmpty()) Assert.fail("No results");

        for (WebElement each : accountActivityPage.descriptions) {
            Assert.assertTrue(each.getText().contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        if (accountActivityPage.descriptions.isEmpty()) Assert.fail("No results");

        for (WebElement each : accountActivityPage.descriptions) {
            Assert.assertFalse(each.getText().contains(string));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String type) {

        if (type.equalsIgnoreCase("deposit")) Assert.assertTrue(accountActivityPage.deposits.size() > 0);

        if (type.equalsIgnoreCase("withdrawal")) Assert.assertTrue(accountActivityPage.withdrawals.size() > 0);

    }

    @When("user selects type {string}")
    public void user_selects_type(String type) {

        Select select = new Select(accountActivityPage.typeOptions);

        select.selectByVisibleText(type);
        BrowserUtils.sleep(2);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String type) {

        if (type.equalsIgnoreCase("deposit")) {
            Assert.assertFalse(BrowserUtils.getStringListFromWebElementList(accountActivityPage.withdrawals).contains(type));
            return;
        }

        if (type.equalsIgnoreCase("withdrawal")) {
            Assert.assertFalse(BrowserUtils.getStringListFromWebElementList(accountActivityPage.deposits).contains(type));
        }
    }
}
