package ru.geekbrains.main.site.at;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sidebar extends PageObject {
    private Page page;

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

    protected Sidebar(WebDriver driver, Page page) {
        super(driver);
        this.page = page;
    }

    public Page clickButton(String name){
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
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        buttonClick(button);
        return page;
    }
}
