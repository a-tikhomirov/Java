package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search extends PageObject{

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

    public Search(WebDriver driver) {
        super(driver);
    }

    public void enterSearchText(String text){
        inputSearch.sendKeys(text);
    }

    public int getProfessionsCount(){ return castToInt(labelProfessionsCount); }

    public int getCoursesCount(){ return castToInt(labelCoursesCount); }

    public int getWebinarsCount() { return castToInt(labelWebinarsCount); }

    public int getForumsCount() { return castToInt(labelForumsCount); }

    public int getBlogsCount() { return castToInt(labelBlogsCount); }

    public int getTestsCount() { return castToInt(labelTestsCount); }

    public boolean geekbrainsLogoExists() { return waitElementDisplayed(buttonCompaniesGeekbrains); }

    private int castToInt(WebElement element){
        return Integer.valueOf(getElementText(element));
    }
}
