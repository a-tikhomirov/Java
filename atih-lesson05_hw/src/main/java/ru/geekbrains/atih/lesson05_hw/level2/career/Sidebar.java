package ru.geekbrains.atih.lesson05_hw.level2.career;

import org.openqa.selenium.WebDriver;

public class Sidebar extends ru.geekbrains.atih.lesson05_hw.common.Sidebar<CareerPage> {
    protected Sidebar(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
