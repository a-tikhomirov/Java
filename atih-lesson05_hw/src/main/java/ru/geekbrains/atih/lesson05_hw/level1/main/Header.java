package ru.geekbrains.atih.lesson05_hw.level1.main;

import org.openqa.selenium.WebDriver;

public class Header extends ru.geekbrains.atih.lesson05_hw.common.Header<MainPage> {
    public Header(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
