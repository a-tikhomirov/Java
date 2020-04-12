package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Sidebar extends PageObject {
    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    public WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    public WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    public WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    public WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    public WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    public WebElement buttonCareer;

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    public WebElement getButton(String name){
        WebElement button = null;
        switch (name){
            case "Курсы": {
                button = buttonCourses;
                break;
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
                button = buttonCareer;
                break;
            }
        }
        if (button == null) {
            throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
        }
        return button;
    }
}
