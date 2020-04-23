package ru.geekbrains.atih.lesson05_hw.level1.main;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.atih.lesson05_hw.common.PageObject;

public class MainPage extends PageObject {
    private Header header;
    private Sidebar sidebar;

    public Header getHeader() {
        return header;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public MainPage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        sidebar = new Sidebar(driver);
    }
}
