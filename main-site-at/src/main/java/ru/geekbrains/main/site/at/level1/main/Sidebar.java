package ru.geekbrains.main.site.at.level1.main;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.main.site.at.common.Sidebar<MainPage> {
    public Sidebar(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
