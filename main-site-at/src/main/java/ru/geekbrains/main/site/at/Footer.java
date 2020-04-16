package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Footer extends PageObject {
    private Page page;

    @FindBy(css = "[class=\"site-footer\"]")
    private WebElement section;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"facebook\"]")
    private WebElement buttonFacebook;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"vk\"]")
    private WebElement buttonVK;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"instagram\"]")
    private WebElement buttonInstagramm;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"youtube\"]")
    private WebElement buttonYoutube;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"telegram\"]")
    private WebElement buttonTelegram;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/feedbacks\"]")
    private WebElement buttonFeedbacks;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"geekbrains.zendesk.com\"]")
    private WebElement buttonHelp;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/company\"]")
    private WebElement buttonAbout;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/license.pdf\"]")
    private WebElement buttonLiscense;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/career/682\"]")
    private WebElement buttonCareer;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"https://forbusiness.geekbrains.ru\"]")
    private WebElement buttonForBusiness;

    @FindBy(css = "[class=\"site-footer__phone\"]")
    private WebElement buttonPhone;

    public Footer(WebDriver driver, Page page) {
        super(driver);
        this.page = page;
    }

    public Page checkSection(){
        assertThat(elementDisplayed(section), is(true));
        assertThat(elementDisplayed(buttonFacebook), is(true));
        assertThat(elementDisplayed(buttonVK), is(true));
        assertThat(elementDisplayed(buttonInstagramm), is(true));
        assertThat(elementDisplayed(buttonYoutube), is(true));
        assertThat(elementDisplayed(buttonTelegram), is(true));
        assertThat(elementDisplayed(buttonFeedbacks), is(true));
        assertThat(elementDisplayed(buttonHelp), is(true));
        assertThat(elementDisplayed(buttonAbout), is(true));
        assertThat(elementDisplayed(buttonLiscense), is(true));
        assertThat(elementDisplayed(buttonCareer), is(true));
        assertThat(elementDisplayed(buttonForBusiness), is(true));
        assertThat(elementDisplayed(buttonPhone), is(true));
        return page;
    }

    public Page checkElementsText(){
        assertThat(getElementText(buttonFeedbacks), equalToCompressingWhiteSpace("Отзывы"));
        assertThat(getElementText(buttonHelp), equalToCompressingWhiteSpace("Помощь"));
        assertThat(getElementText(buttonAbout), equalToCompressingWhiteSpace("О проекте"));
        assertThat(getElementText(buttonLiscense), equalToCompressingWhiteSpace("Лицензия"));
        assertThat(getElementText(buttonCareer), equalToCompressingWhiteSpace("Вакансии"));
        assertThat(getElementText(buttonForBusiness), equalToCompressingWhiteSpace("Компаниям"));
        assertThat(getElementText(buttonPhone), equalToCompressingWhiteSpace("8 800 700-68-41"));
        return page;
    }
}
