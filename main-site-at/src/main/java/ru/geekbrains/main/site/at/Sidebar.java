package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Sidebar extends PageObject {
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

    public Sidebar(WebDriver driver) {
        super(driver);
    }

    public void buttonCoursesClick(){ buttonClick(buttonCourses); }

    public void buttonEventsClick(){ buttonClick(buttonEvents); }

    public void buttonTopicsClick() { buttonClick(buttonTopics); }

    public void buttonPostsClick() { buttonClick(buttonPosts); }

    public void buttonTestsClick() { buttonClick(buttonTests); }

    public void buttonCareerClick() { buttonClick(buttonCareer); }
}
