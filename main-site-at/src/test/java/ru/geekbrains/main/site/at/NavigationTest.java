package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest extends BaseTest{

    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/courses");
        coursesPage.popUpClose();
    }

    @DisplayName("Проверка навигации элементов sidebar страницы https://geekbrains.ru/courses")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{1}\": проверка заголовка страницы, проверка элементов блоков Header и Footer")
    @MethodSource("webElementAndStringProvider")
    void checkSideBarNavigation(WebElement element, String expectedHeader){
        coursesPage.buttonClick(element);
        checkHeader(expectedHeader);
        checkFooter();
    }

    Stream<Arguments> webElementAndStringProvider(){
        return Stream.of(   Arguments.of(coursesPage.sidebar.buttonCourses, "Курсы"),
                            Arguments.of(coursesPage.sidebar.buttonEvents, "Вебинары"),
                            Arguments.of(coursesPage.sidebar.buttonTopics, "Форум"),
                            Arguments.of(coursesPage.sidebar.buttonPosts, "Блог"),
                            Arguments.of(coursesPage.sidebar.buttonTests, "Тесты"),
                            Arguments.of(coursesPage.sidebar.buttonCareer, "Карьера"));
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
