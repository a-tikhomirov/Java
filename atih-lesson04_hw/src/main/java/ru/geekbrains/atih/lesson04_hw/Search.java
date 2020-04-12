package ru.geekbrains.atih.lesson04_hw;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends PageObject{

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    public WebElement inputSearch;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    public WebElement labelProfessionsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    public WebElement labelCoursesCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    public WebElement labelWebinarsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    public WebElement labelBlogsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    public WebElement labelForumsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    public WebElement labelTestsCount;

    @FindBy(css = "[class*=\"search-page-block\"] [class=\"company-item__pic\"] [alt*=\"GeekBrains\"]")
    public WebElement buttonCompaniesGeekbrains;

    public Search(WebDriver driver) {
        super(driver);
    }

    public int getLabelCounter(String name) {
        int counter = -1;
        switch (name){
            case "Профессии": {
                counter = getElementTextToInt(labelProfessionsCount);
                break;
            }
            case "Курсы": {
                counter = getElementTextToInt(labelCoursesCount);
                break;
            }
            case "Вебинары": {
                counter = getElementTextToInt(labelWebinarsCount);
                break;
            }
            case "Блоги": {
                counter = getElementTextToInt(labelBlogsCount);
                break;
            }
            case "Форумы": {
                counter = getElementTextToInt(labelForumsCount);
                break;
            }
            case "Тесты": {
                counter = getElementTextToInt(labelTestsCount);
                break;
            }
        }
        if (counter == -1) {
            throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
        }
        return counter;
    }
}
