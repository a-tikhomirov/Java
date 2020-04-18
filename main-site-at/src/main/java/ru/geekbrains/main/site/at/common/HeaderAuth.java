package ru.geekbrains.main.site.at.common;

import org.openqa.selenium.WebDriver;

public class HeaderAuth<T> extends Header{
    public HeaderAuth(WebDriver driver, Class ownerPageClass) {
        super(driver, ownerPageClass);
    }
}
