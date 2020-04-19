package ru.geekbrains.main.site.at.level2.courses;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.PageObject;

public class HeaderNavigationTab extends PageObject {
    private CoursesPage coursesPage;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#prof-compact\"]")
    private WebElement buttonNavProfessions;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#free\"]")
    private WebElement buttonFreeIntensives;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href=\"#cour-new\"]")
    private WebElement buttonNavCourses;

    @FindBy(css = "[class*=\"nav nav-tabs\"] [href*=\"forbusiness\"]")
    private WebElement buttonForBusiness;

    public HeaderNavigationTab(WebDriver driver, CoursesPage coursesPage) {
        super(driver);
        this.coursesPage = coursesPage;
    }

    public CoursesPage clickButton(String name){
        WebElement button;
        switch (name){
            case "Профессии": {
                button = buttonNavProfessions;
                break;
            }
            case "Бесплатные интенсивы": {
                button = buttonFreeIntensives;
                break;
            }
            case "Курсы": {
                button = buttonNavCourses;
                break;
            }
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        buttonClick(button);
        return coursesPage;
    }
}
