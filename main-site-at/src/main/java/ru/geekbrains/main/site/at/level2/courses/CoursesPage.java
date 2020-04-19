package ru.geekbrains.main.site.at.level2.courses;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.common.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CoursesPage extends PageObject implements Page {
    private Header header;
    private Footer footer;
    private Sidebar sidebar;

    private HeaderNavigationTab headerNavigationTab;
    private FiltersForm filtersForm;

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public Sidebar getSidebar() {
        return sidebar;
    }

    public HeaderNavigationTab getHeaderNavigationTab() {
        return headerNavigationTab;
    }

    public FiltersForm getFiltersForm() {
        return filtersForm;
    }

    @FindBy(css = "div[id=\"cour-new\"]")
    private WebElement divCourses;

    public CoursesPage(WebDriver driver, boolean authorized) {
        super(driver);
        header = authorized?
                new HeaderAuth(driver, CoursesPage.class):
                new HeaderNoAuth(driver, CoursesPage.class);
        footer = new Footer(driver, CoursesPage.class);
        sidebar = new Sidebar(driver, CoursesPage.class, authorized);

        headerNavigationTab = new HeaderNavigationTab(driver, this);
        filtersForm = new FiltersForm(driver, this);
    }

    public CoursesPage(WebDriver driver) {
        this(driver, false);
    }

    public CoursesPage checkCoursesForText(String text){
        String xpath = String.format("//span[@class=\"gb-course-card__title-text\"][contains(.,\"%s\")]", text);
        boolean actual;
        try {
            actual = elementDisplayed(divCourses.findElement(By.xpath(xpath)));
        } catch (NoSuchElementException e) {
            actual = false;
            e.printStackTrace();
        }
        assertThat(actual,is(true));
        return this;
    }
}
