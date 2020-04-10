package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Header extends PageObject {

    @FindBy(css = "[id=\"top-menu\"]")
    private WebElement section;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] [class=\"show-search-form\"]")
    private WebElement buttonSearch;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/login\"]")
    private WebElement buttonLogin;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/register\"]")
    private WebElement buttonRegister;

    public Header(WebDriver driver) {
        super(driver);
    }

    public boolean sectionExists(){ return elementDisplayed(section); }

    public boolean searchExists(){ return elementDisplayed(buttonSearch); }

    public boolean loginExists(){
        return elementDisplayed(buttonLogin);
    }

    public boolean registerExists() { return elementDisplayed(buttonRegister); }

    public String getHeaderText(){ return getElementText(labelHeader); }

    public void searchClick(){ buttonClick(buttonSearch); }
}
