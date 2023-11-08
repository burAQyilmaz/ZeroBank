package com.zeroBank.pages;

import com.zeroBank.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//i[@class='icon-user']/..")
    public WebElement userNameTag;
    @FindAll({
            @FindBy(tagName = "a"), //genearal
            @FindBy(css = "td a"), //account summary page
            @FindBy(className = "headers"), //online banking page  "headers"
            @FindBy(css = "#pages-nav li"), //online banking page "page links"
            @FindBy(css = "#tabs li")  //pay bills page
    })
    public List<WebElement> links;


    public void clickLinkFromWebElementList(String linkText) {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        for (WebElement eachWebElement : links) {

            if (!eachWebElement.isEnabled() || !eachWebElement.isDisplayed()) continue;

            if (eachWebElement.getText().trim().equalsIgnoreCase(linkText)) {
                eachWebElement.click();
                Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                return;
            }
        }

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        throw new RuntimeException(linkText + " is not found or clickable");
    }
}
