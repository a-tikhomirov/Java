package ru.geekbrains.atih.lesson04_hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends PageObject {

    @FindBy(css = "[id=\"top-menu\"]")
    public WebElement section;

    @FindBy(css = "[class=\"gb-header__title\"]")
    public WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] [class=\"show-search-form\"]")
    public WebElement buttonSearch;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/login\"]")
    public WebElement buttonLogin;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/register\"]")
    public WebElement buttonRegister;

    public Header(WebDriver driver) {
        super(driver);
    }
}
