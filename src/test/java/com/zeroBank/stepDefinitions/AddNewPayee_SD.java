package com.zeroBank.stepDefinitions;

import com.zeroBank.pages.PayBillsPage;
import com.zeroBank.utility.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddNewPayee_SD {
    PayBillsPage payBillsPage = new PayBillsPage();
    Select select;

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> table) {

        List<String> values = new ArrayList<>(table.values());

        for (int i = 0; i < payBillsPage.inputsOfAddNewPayeeTab.size(); i++)
            payBillsPage.inputsOfAddNewPayeeTab.get(i).sendKeys(values.get(i));

        payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedAlertMsg) {
        BrowserUtils.waitForVisibility(payBillsPage.alertContent, 5);

        Assert.assertEquals(expectedAlertMsg, payBillsPage.alertContent.getText());
    }


}
