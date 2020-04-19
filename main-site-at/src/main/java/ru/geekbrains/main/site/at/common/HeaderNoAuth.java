package ru.geekbrains.main.site.at.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderNoAuth<T> extends Header {
    @FindBy(css = "[class*=\"gb-header\"] [href=\"/login\"]")
    private WebElement buttonLogin;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/register\"]")
    private WebElement buttonRegister;

    public HeaderNoAuth(WebDriver driver, Class<T> ownerPageClass) {
        super(driver, ownerPageClass);
    }

    @Override
    public Page checkSection() {
        checkElementsDisplayed(new WebElement[] {
                section,
                buttonSearch,
                buttonLogin,
                buttonRegister
        });
        return (Page) PageFactory.initElements(driver, ownerPageClass);
    }
}
