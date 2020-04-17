package ru.geekbrains.atih.lesson05_hw;

import org.hamcrest.Matcher;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;

public class Search extends PageObject{
    private Page page;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    private WebElement labelProfessionsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    private WebElement labelCoursesCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    private WebElement labelWebinarsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    private WebElement labelBlogsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    private WebElement labelForumsCount;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    private WebElement labelTestsCount;

    @FindBy(css = "[class*=\"search-page-block\"] [class=\"company-item__pic\"] [alt*=\"GeekBrains\"]")
    private WebElement buttonCompaniesGeekbrains;

    public Search(WebDriver driver, Page page) {
        super(driver);
        this.page = page;
    }

    public Search enterSearchText(String text){
        waitElementDisplayed(inputSearch);
        inputSearch.sendKeys(text);
        return this;
    }

    public Search checkElement(String name, Matcher matcher) {
        Object actual = null;
        switch (name){
            case "Профессии": {
                actual = getElementTextToInt(labelProfessionsCount);
                break;
            }
            case "Курсы": {
                actual = getElementTextToInt(labelCoursesCount);
                break;
            }
            case "Вебинары": {
                actual = getElementTextToInt(labelWebinarsCount);
                break;
            }
            case "Блоги": {
                actual = getElementTextToInt(labelBlogsCount);
                break;
            }
            case "Форумы": {
                actual = getElementTextToInt(labelForumsCount);
                break;
            }
            case "Тесты": {
                actual = getElementTextToInt(labelTestsCount);
                break;
            }
            case "Geekbrains": {
                actual = waitElementDisplayed(buttonCompaniesGeekbrains);
                break;
            }
            default: {
                throw new NotFoundException("Элемента " + name + " нет в классе " + getClass().getName());
            }
        }
        assertThat(actual, matcher);
        return this;
    }
}
