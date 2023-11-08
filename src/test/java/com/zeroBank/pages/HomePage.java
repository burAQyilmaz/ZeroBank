package com.zeroBank.pages;

import com.zeroBank.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css ="#pages-nav li")
    public List<WebElement> homaPageLinks;
}
