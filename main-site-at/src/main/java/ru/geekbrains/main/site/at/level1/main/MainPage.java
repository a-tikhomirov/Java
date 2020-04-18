package ru.geekbrains.main.site.at.level1.main;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.common.*;

public class MainPage extends PageObject implements Page {
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

    public MainPage(WebDriver driver) {
        super(driver);
        header = new HeaderAuth(driver, MainPage.class);
        footer = new Footer(driver, MainPage.class);
        sidebar = new Sidebar(driver, MainPage.class, true);
    }
}
