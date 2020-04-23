package ru.geekbrains.atih.lesson05_hw.level2.courses;

import org.openqa.selenium.WebDriver;

public class Header extends ru.geekbrains.atih.lesson05_hw.common.Header<CoursesPage> {
    public Header(WebDriver driver) {
        super(driver, CoursesPage.class);
    }
}
