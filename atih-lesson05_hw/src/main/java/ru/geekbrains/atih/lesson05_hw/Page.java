package ru.geekbrains.atih.lesson05_hw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page extends PageObject {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;
    private Search search;

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public Search getSearch() {
        return search;
    }

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClose;

    public Page(WebDriver driver) {
        super(driver);
        footer = new Footer(driver, this);
        sidebar = new Sidebar(driver, this);
        header = new Header(driver, this);
        search = new Search(driver, this);
    }

    public Page popUpClose(){
        if (elementDisplayed(buttonPopUpClose)) buttonPopUpClose.click();
        return this;
    }
}
