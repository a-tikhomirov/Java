package ru.geekbrains.main.site.at.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Header<T> extends PageObject {
    protected Class<T> ownerPageClass;

    @FindBy(css = "[id=\"top-menu\"]")
    protected WebElement section;

    @FindBy(css = "[class=\"gb-header__title\"]")
    protected WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] a[class=\"show-search-form\"]")
    protected WebElement buttonSearch;

    public Header(WebDriver driver, Class<T> ownerPageClass) {
        super(driver);
        this.ownerPageClass = ownerPageClass;
    }

    public Page checkSection() {
        checkElementsDisplayed(new WebElement[] {
                section,
                buttonSearch
        });
        return (Page) PageFactory.initElements(driver, ownerPageClass);
    }

    public Page checkTitle(String expectedTitle){
        checkText(labelHeader, expectedTitle);
        return (Page) PageFactory.initElements(driver, ownerPageClass);
    }

    public Search clickSearch(){
        buttonClick(buttonSearch);
        return PageFactory.initElements(driver, Search.class);
    }
}
