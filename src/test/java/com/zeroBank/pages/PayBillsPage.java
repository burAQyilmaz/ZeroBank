package com.zeroBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage{

    @FindBy(css="#ui-tabs-2 .control-group div *")
    public List<WebElement> inputsOfAddNewPayeeTab;

    @FindBy(id = "alert_content")
    public WebElement alertContent;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "pc_currency")
    public WebElement currencyDropDown;

    @FindBy(id = "pc_amount")
    public WebElement inputAmount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement radioButtonDollar;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;
}
