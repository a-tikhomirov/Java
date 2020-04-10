package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.geekbrains.main.site.at.base.BaseTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest{

    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/career");
        coursesPage.popUpClose();
        coursesPage.header.searchClick();
        coursesPage.search.enterSearchText("Java");
    }

    @Test
    void checkProfessions() {
        Assertions.assertTrue(coursesPage.search.getProfessionsCount() >= 2);
    }

    @Test
    void checkCourses() {
        Assertions.assertTrue(coursesPage.search.getCoursesCount() > 15);
    }

    @Test
    void checkWebinars() {
        int webinarsCount = coursesPage.search.getWebinarsCount();
        Assertions.assertTrue( webinarsCount > 180 && webinarsCount < 300);
    }

    @Test
    void checkBlogs() {
        Assertions.assertTrue(coursesPage.search.getBlogsCount() > 300);
    }

    @Test
    void checkPosts() {
        Assertions.assertTrue(coursesPage.search.getForumsCount() != 350);
    }

    @Test
    void checkTest() {
        Assertions.assertTrue(coursesPage.search.getTestsCount() != 0);
    }

    @Test
    void checkGeekbrainsLogoExist() {
        Assertions.assertTrue(coursesPage.search.geekbrainsLogoExists());
    }
}
