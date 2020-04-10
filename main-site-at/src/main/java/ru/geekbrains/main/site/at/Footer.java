package ru.geekbrains.main.site.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Footer extends PageObject {
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

    public Footer(WebDriver driver) {
        super(driver);
    }

    public boolean sectionExists(){ return elementDisplayed(section); }

    public boolean socialLinksExists(){
        boolean exists = true;
        exists &= elementDisplayed(buttonFacebook);
        exists &= elementDisplayed(buttonVK);
        exists &= elementDisplayed(buttonInstagramm);
        exists &= elementDisplayed(buttonYoutube);
        exists &= elementDisplayed(buttonTelegram);
        return exists;
    }

    public String getFeedbacksText(){ return getElementText(buttonFeedbacks); }

    public String getHelpText(){ return getElementText(buttonHelp); }

    public String getAboutText(){ return getElementText(buttonAbout); }

    public String getLiscenseText(){ return getElementText(buttonLiscense); }

    public String getCareerText(){ return getElementText(buttonCareer); }

    public String getForBusinessText(){ return getElementText(buttonForBusiness); }

    public String getPhoneText(){ return getElementText(buttonPhone); }
}
