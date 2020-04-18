package ru.geekbrains.main.site.at.common;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.level2.career.CareerPage;
import ru.geekbrains.main.site.at.level2.courses.CoursesPage;

public class Sidebar<T> extends PageObject {
    private Class<T> ownerPageClass;
    private boolean authorized;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    public Sidebar(WebDriver driver, Class<T> ownerPageClass, boolean authorized) {
        super(driver);
        this.ownerPageClass = ownerPageClass;
        this.authorized = authorized;
    }

    public Page clickButton(String name){
        WebElement button;
        switch (name){
            case "Курсы": {
                buttonClick(buttonCourses);
                return new CoursesPage(driver, authorized);
            }
            case "Вебинары": {
                button = buttonEvents;
                break;
            }
            case "Форум": {
                button = buttonTopics;
                break;
            }
            case "Блог": {
                button = buttonPosts;
                break;
            }
            case "Тесты": {
                button = buttonTests;
                break;
            }
            case "Карьера": {
                buttonClick(buttonCareer);
                return new CareerPage(driver, authorized);
            }
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        buttonClick(button);
        return (Page) PageFactory.initElements(driver, ownerPageClass);
    }
}
