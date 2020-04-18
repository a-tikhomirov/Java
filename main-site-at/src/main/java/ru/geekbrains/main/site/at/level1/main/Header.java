package ru.geekbrains.main.site.at.level1.main;

import org.openqa.selenium.WebDriver;

public class Header extends ru.geekbrains.main.site.at.common.Header<MainPage> {
    public Header(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
