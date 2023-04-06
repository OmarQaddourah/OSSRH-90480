package com.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static core.helpers.ElementHelpers.elementToBeVisible;

@Getter
public class Homepage {

    public Homepage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//img[@alt='Google']")
    private WebElement googleLogo;

    public WebElement getGoogleLogo() {
        return elementToBeVisible(this.googleLogo);
    }
}
