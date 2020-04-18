package ru.geekbrains.main.site.at.level2.courses;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.PageObject;

public class FiltersForm extends PageObject {
    private CoursesPage coursesPage;

    @FindBy(css = "input[id=\"filter-0\"]")
    private WebElement checkBoxFilterFree;

    @FindBy(css = "input[id=\"filter-9\"]")
    private WebElement checkBoxFilterQA;

    public FiltersForm(WebDriver driver, CoursesPage coursesPage) {
        super(driver);
        this.coursesPage = coursesPage;
    }

    public CoursesPage clickCheckbox(String name){
        WebElement checkBox = null;
        switch (name){
            case "Бесплатные": {
                checkBox = checkBoxFilterFree;
                break;
            }
            case "Тестирование": {
                checkBox = checkBoxFilterQA;
                break;
            }
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        checkBoxClick(checkBox);
        return coursesPage;
    }
}
