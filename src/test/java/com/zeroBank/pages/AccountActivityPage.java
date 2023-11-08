package com.zeroBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage {

    @FindBy(id = "aa_accountId")
    public WebElement dropDownSelectedOption;

    @FindBy(partialLinkText = "Find Transactions")
    public WebElement findTransactionsLink;

    @FindBy(xpath = "//h2[.='Find Transactions']")
    public WebElement headerFindTransactions;

    @FindBy(id="aa_description")
    public WebElement inputDescription;

    @FindBy(id = "aa_fromDate")
    public WebElement inputFromDate;

    @FindBy(id = "aa_toDate")
    public WebElement inputToDate;

    @FindBy(id = "aa_type")
    public WebElement typeOptions;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> listedDates;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> descriptions;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> deposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> withdrawals;
}
