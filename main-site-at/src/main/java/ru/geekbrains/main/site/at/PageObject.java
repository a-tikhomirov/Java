package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
        PageFactory.initElements(driver, this);
    }

    protected boolean elementDisplayed(WebElement element){
        boolean displayed;
        try {
            displayed = element.isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            displayed = false;
        }
        return displayed;
    }

    protected boolean waitElementDisplayed(WebElement element){
        boolean displayed = true;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        }
        catch (org.openqa.selenium.TimeoutException e) {
            displayed = false;
        }
        return displayed;
    }

    protected void buttonClick(WebElement button){
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    protected String getElementText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
