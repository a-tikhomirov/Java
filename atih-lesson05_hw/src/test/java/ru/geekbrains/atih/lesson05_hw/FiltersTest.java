package ru.geekbrains.atih.lesson05_hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.atih.lesson05_hw.level1.AuthPage;
import ru.geekbrains.atih.lesson05_hw.level2.courses.CoursesPage;
import ru.geekbrains.atih.lesson05_hw.base.BaseTest;

import java.util.stream.Stream;

@DisplayName("Проверка фильтров на странице https://geekbrains.ru/courses")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FiltersTest extends BaseTest {
    private CoursesPage coursesPage;

    @BeforeAll
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/login");
        coursesPage = PageFactory.initElements(driver, AuthPage.class)
                .loginAsCustomer("hao17583@bcaoo.com", "hao17583")
                .getSidebar().clickCourses()
                .clickNavCourses()
                .clickCheckbox("Бесплатные")
                .clickCheckbox("Тестирование");
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
