package ru.geekbrains.main.site.at.level2.career;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.level2.career.CareerPage;

public class Footer extends ru.geekbrains.main.site.at.common.Footer<CareerPage> {
    public Footer(WebDriver driver) {
        super(driver, CareerPage.class);
    }
}
