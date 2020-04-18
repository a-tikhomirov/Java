package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.level1.AuthPage;
import ru.geekbrains.main.site.at.level2.courses.CoursesPage;

import java.util.stream.Stream;

@DisplayName("Проверка фильтров на странице https://geekbrains.ru/courses")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FiltersTest extends BaseTest {
    private CoursesPage coursesPage;

    @BeforeAll
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/login");
        coursesPage = (CoursesPage) PageFactory.initElements(driver, AuthPage.class)
                .loginAsCustomer("hao17583@bcaoo.com", "hao17583")
                .getSidebar().clickButton("Курсы")
                .getHeader().checkTitle("Курсы");
        coursesPage
                .getHeaderNavigationTab().clickButton("Курсы")
                .getFiltersForm().clickCheckbox("Бесплатные")
                .getFiltersForm().clickCheckbox("Тестирование");
    }

    @DisplayName("Проверка результатов фильтрации")
    @ParameterizedTest(name = "{index} ==> В отображенных курсах есть: \"{0}\"")
    @MethodSource("stringProvider")
    void checkMain(String courseName){
        coursesPage.checkCoursesForText(courseName);
    }

    static Stream<String> stringProvider(){
        return Stream.of(
                "Тестирование ПО. Уровень 1",
                "Тестирование ПО. Уровень 2"
        );
    }

    @AfterAll
    protected void tearDown(){
        super.tearDown();
    }
}
