package ru.geekbrains.atih.lesson05_hw.level2.career;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.atih.lesson05_hw.common.PageObject;

public class CareerPage extends PageObject {
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

    public CareerPage(WebDriver driver) {
        super(driver);
        footer = new Footer(driver);
        sidebar = new Sidebar(driver);
        header = new Header(driver);
    }

    public CareerPage popUpClose(){
        if (elementDisplayed(buttonPopUpClose)) buttonPopUpClose.click();
        return this;
    }
}
