package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;

@DisplayName("Проверка навигации")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class NavigationTest extends BaseTest{

    @BeforeEach
    protected void SetUp(){
        super.setUpDriver();
    }

    @DisplayName("Проверка элементов навигации sidebar страницы https://geekbrains.ru/courses")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(String navElementName){
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, Page.class)
                .getSidebar().clickButton(navElementName)
                .getHeader().checkSection()
                .getHeader().checkTitle(navElementName)
                .getFooter().checkSection()
                .getFooter().checkElementsText();
    }

    Stream<String> stringProvider(){
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @AfterEach
    protected void tearDown(){
        super.tearDown();
    }
}
