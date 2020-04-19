package ru.geekbrains.atih.lesson04_hw;

import org.junit.jupiter.api.*;
import ru.geekbrains.atih.lesson04_hw.base.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("Проверка результатов поиска по ключевому слову Java")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest{

    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/career");
        coursesPage.buttonClick(coursesPage.header.buttonSearch);
        coursesPage.search.inputSearch.sendKeys("Java");
    }

    @DisplayName("1 ==> Число профессий >= 2")
    @Test
    @Order(1)
    void checkProfessions() {
        assertThat(coursesPage.search.getLabelCounter("Профессии"), greaterThanOrEqualTo(2));
    }

    @DisplayName("2 ==> Число курсов > 15")
    @Test
    @Order(2)
    void checkCourses() {
        assertThat(coursesPage.search.getLabelCounter("Курсы"), greaterThan(15));
    }

    @DisplayName("3 ==> Число вебинаров > 180 и < 300")
    @Test
    @Order(3)
    void checkWebinars() {
        assertThat(coursesPage.search.getLabelCounter("Вебинары"), allOf(
                greaterThan(180),
                lessThan(300))
        );
    }

    @DisplayName("4 ==> Число блогов > 300")
    @Test
    @Order(4)
    void checkBlogs() {
        assertThat(coursesPage.search.getLabelCounter("Блоги"), greaterThan(300));
    }

    @DisplayName("5 ==> Число форумов не 350")
    @Test
    @Order(5)
    void checkPosts() {
        assertThat(coursesPage.search.getLabelCounter("Форумы"), not(350));
    }

    @DisplayName("6 ==> Число тестов не 0")
    @Test
    @Order(6)
    void checkTest() {
        assertThat(coursesPage.search.getLabelCounter("Тесты"), not(0));
    }

    @DisplayName("7 ==> В Проектах и компаниях отображается GeekBrains")
    @Test
    @Order(7)
    void checkGeekbrainsLogoExist() {
        assertThat(coursesPage.waitElementDisplayed(coursesPage.search.buttonCompaniesGeekbrains), is(true));
    }
}
