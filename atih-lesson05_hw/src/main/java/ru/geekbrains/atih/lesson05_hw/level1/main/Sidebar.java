package ru.geekbrains.atih.lesson05_hw.level1.main;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.atih.lesson05_hw.common.Sidebar<MainPage> {
    public Sidebar(WebDriver driver) {
        super(driver, MainPage.class);
    }
}
