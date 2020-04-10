package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CoursesPage extends PageObject {
    public Header header;
    public Footer footer;
    public Sidebar sidebar;
    public Search search;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClose;

    public CoursesPage(WebDriver driver) {
        super(driver);
        footer = new Footer(driver);
        sidebar = new Sidebar(driver);
        header = new Header(driver);
        search = new Search(driver);
    }

    public void popUpClose(){
        if (elementDisplayed(buttonPopUpClose)) buttonPopUpClose.click();
    }
}
