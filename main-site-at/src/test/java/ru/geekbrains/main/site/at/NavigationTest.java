package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.geekbrains.main.site.at.base.BaseTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest extends BaseTest{

    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/courses");
        coursesPage.popUpClose();
    }

    @Test
    void checkNavCourses() throws InterruptedException {
        coursesPage.sidebar.buttonCoursesClick();
        checkHeader("Курсы");
        checkFooter();
    }

    @Test
    void checkNavEvents() {
        coursesPage.sidebar.buttonEventsClick();
        checkHeader("Вебинары");
        checkFooter();
    }

    @Test
    void checkNavTopics() {
        coursesPage.sidebar.buttonTopicsClick();
        checkHeader("Форум");
        checkFooter();
    }

    @Test
    void checkNavPosts() {
        coursesPage.sidebar.buttonPostsClick();
        checkHeader("Блог");
        checkFooter();
    }

    @Test
    void checkNavTests() {
        coursesPage.sidebar.buttonTestsClick();
        checkHeader("Тесты");
        checkFooter();
    }

    @Test
    void checkNavCareer() {
        coursesPage.sidebar.buttonCareerClick();
        checkHeader("Карьера");
        checkFooter();
    }

    private void checkHeader(String headerText){
        Assertions.assertTrue(coursesPage.header.sectionExists());
        Assertions.assertEquals(headerText, coursesPage.header.getHeaderText());
        Assertions.assertTrue(coursesPage.header.searchExists());
        Assertions.assertTrue(coursesPage.header.loginExists());
        Assertions.assertTrue(coursesPage.header.registerExists());
    }

    private void checkFooter(){
        Assertions.assertTrue(coursesPage.footer.sectionExists());
        Assertions.assertTrue(coursesPage.footer.socialLinksExists());
        Assertions.assertEquals("Отзывы", coursesPage.footer.getFeedbacksText());
        Assertions.assertEquals("Помощь", coursesPage.footer.getHelpText());
        Assertions.assertEquals("О проекте", coursesPage.footer.getAboutText());
        Assertions.assertEquals("Лицензия", coursesPage.footer.getLiscenseText());
        Assertions.assertEquals("Вакансии", coursesPage.footer.getCareerText());
        Assertions.assertEquals("Компаниям", coursesPage.footer.getForBusinessText());
        Assertions.assertEquals("8 800 700-68-41", coursesPage.footer.getPhoneText());
    }
}
