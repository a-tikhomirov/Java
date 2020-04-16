package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Header extends PageObject {
    private Page page;

    @FindBy(css = "[id=\"top-menu\"]")
    private WebElement section;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement labelHeader;

    @FindBy(css = "[class*=\"gb-header\"] [class=\"show-search-form\"]")
    private WebElement buttonSearch;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/login\"]")
    private WebElement buttonLogin;

    @FindBy(css = "[class*=\"gb-header\"] [href=\"/register\"]")
    private WebElement buttonRegister;

    public Header(WebDriver driver, Page page) {
        super(driver);
        this.page = page;
    }

    public Page checkSection(){
        assertThat(elementDisplayed(section), is(true));
        assertThat(elementDisplayed(buttonSearch), is(true));
        assertThat(elementDisplayed(buttonLogin), is(true));
        assertThat(elementDisplayed(buttonRegister), is(true));
        return page;
    }

    public Page checkTitle(String title){
        assertThat(getElementText(labelHeader), equalToCompressingWhiteSpace(title));
        return page;
    }

    public Search clickSearch(){
        buttonClick(buttonSearch);
        return page.getSearch();
    }
}
