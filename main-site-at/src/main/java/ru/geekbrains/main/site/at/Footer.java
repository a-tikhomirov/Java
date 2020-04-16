package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        checkElementsDisplayed(new WebElement[] {
                section,
                buttonFacebook,
                buttonVK,
                buttonInstagramm,
                buttonYoutube,
                buttonTelegram,
                buttonFeedbacks,
                buttonHelp,
                buttonAbout,
                buttonLiscense,
                buttonCareer,
                buttonForBusiness,
                buttonPhone
        });
        return page;
    }

    public Page checkElementsText(){
        checkText(buttonFeedbacks,"Отзывы");
        checkText(buttonHelp,"Помощь");
        checkText(buttonAbout,"О проекте");
        checkText(buttonLiscense,"Лицензия");
        checkText(buttonCareer,"Вакансии");
        checkText(buttonForBusiness,"Компаниям");
        checkText(buttonPhone,"8 800 700-68-41");
        return page;
    }
}
