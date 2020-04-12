package ru.geekbrains.atih.lesson04_hw;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.geekbrains.atih.lesson04_hw.base.BaseTest;

import java.util.stream.Stream;

@DisplayName("Проверка элементов навигации sidebar страницы https://geekbrains.ru/courses")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest extends BaseTest{

    @BeforeAll
    protected void setUp(){
        super.setUp();
        coursesPage = new CoursesPage(driver);
        driver.get("https://geekbrains.ru/courses");
        coursesPage.popUpClose();
    }

    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(String navElementName){
        coursesPage.buttonClick(coursesPage.sidebar.getButton(navElementName));
        checkHeader(navElementName);
        checkFooter();
    }

    Stream<String> stringProvider(){
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    private void checkHeader(String headerText){
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.section));
        Assertions.assertEquals(headerText, coursesPage.getElementText(coursesPage.header.labelHeader));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonSearch));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonLogin));
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.header.buttonRegister));
    }

    private void checkFooter(){
        Assertions.assertTrue(coursesPage.elementDisplayed(coursesPage.footer.section));
        Assertions.assertTrue(coursesPage.footer.socialLinksExists());
        Assertions.assertEquals("Отзывы", coursesPage.getElementText(coursesPage.footer.buttonFeedbacks));
        Assertions.assertEquals("Помощь", coursesPage.getElementText(coursesPage.footer.buttonHelp));
        Assertions.assertEquals("О проекте", coursesPage.getElementText(coursesPage.footer.buttonAbout));
        Assertions.assertEquals("Лицензия", coursesPage.getElementText(coursesPage.footer.buttonLiscense));
        Assertions.assertEquals("Вакансии", coursesPage.getElementText(coursesPage.footer.buttonCareer));
        Assertions.assertEquals("Компаниям", coursesPage.getElementText(coursesPage.footer.buttonForBusiness));
        Assertions.assertEquals("8 800 700-68-41", coursesPage.getElementText(coursesPage.footer.buttonPhone));
    }
}
