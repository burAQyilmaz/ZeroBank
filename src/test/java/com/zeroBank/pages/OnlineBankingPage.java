package com.zeroBank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlineBankingPage extends BasePage{
    @FindBy(className = "headers")
    public List<WebElement> headers;
}
