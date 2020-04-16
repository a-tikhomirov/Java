package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends PageObject {
    private Page page;

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

    public Header(WebDriver driver, Page page) {
        super(driver);
        this.page = page;
    }

    public Page checkSection(){
        checkElementsDisplayed(new WebElement[] {
                section,
                buttonSearch,
                buttonLogin,
                buttonRegister
        });
        return page;
    }

    public Page checkTitle(String expectedTitle){
        checkText(labelHeader, expectedTitle);
        return page;
    }

    public Search clickSearch(){
        buttonClick(buttonSearch);
        return page.getSearch();
    }
}
