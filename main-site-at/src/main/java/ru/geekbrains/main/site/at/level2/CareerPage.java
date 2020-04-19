package ru.geekbrains.main.site.at.level2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.*;

public class CareerPage extends PageObject implements Page {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClose;

    public CareerPage(WebDriver driver, boolean authorized) {
        super(driver);
        header = authorized?
                new HeaderAuth(driver, CareerPage.class):
                new HeaderNoAuth(driver, CareerPage.class);
        footer = new Footer(driver, CareerPage.class);
        sidebar = new Sidebar(driver, CareerPage.class, authorized);
    }

    public CareerPage(WebDriver driver) {
        this(driver, false);
    }

    public CareerPage popUpClose(){
        if (elementDisplayed(buttonPopUpClose)) buttonPopUpClose.click();
        return this;
    }
}
