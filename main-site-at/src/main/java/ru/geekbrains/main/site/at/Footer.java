package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends PageObject {
    @FindBy(css = "[class=\"site-footer\"]")
    public WebElement section;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"facebook\"]")
    public WebElement buttonFacebook;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"vk\"]")
    public WebElement buttonVK;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"instagram\"]")
    public WebElement buttonInstagramm;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"youtube\"]")
    public WebElement buttonYoutube;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"telegram\"]")
    public WebElement buttonTelegram;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/feedbacks\"]")
    public WebElement buttonFeedbacks;

    @FindBy(css = "[class*=\"site-footer\"] [href*=\"geekbrains.zendesk.com\"]")
    public WebElement buttonHelp;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/company\"]")
    public WebElement buttonAbout;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/license.pdf\"]")
    public WebElement buttonLiscense;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"/career/682\"]")
    public WebElement buttonCareer;

    @FindBy(css = "[class*=\"site-footer\"] [href=\"https://forbusiness.geekbrains.ru\"]")
    public WebElement buttonForBusiness;

    @FindBy(css = "[class=\"site-footer__phone\"]")
    public WebElement buttonPhone;

    public Footer(WebDriver driver) {
        super(driver);
    }

    public boolean socialLinksExists(){
        boolean exists = true;
        exists &= elementDisplayed(buttonFacebook);
        exists &= elementDisplayed(buttonVK);
        exists &= elementDisplayed(buttonInstagramm);
        exists &= elementDisplayed(buttonYoutube);
        exists &= elementDisplayed(buttonTelegram);
        return exists;
    }
}
