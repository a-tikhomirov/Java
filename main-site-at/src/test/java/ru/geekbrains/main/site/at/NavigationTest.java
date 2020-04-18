package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;
import ru.geekbrains.main.site.at.level2.career.CareerPage;

import java.util.stream.Stream;

@DisplayName("Проверка элементов навигации sidebar страницы https://geekbrains.ru/career")
public class NavigationTest extends BaseTest{

    @BeforeEach
    protected void SetUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/career");
    }

    @DisplayName("Проверка элементов и заголовка Header, проверка элементов Footer")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkSideBarNavigation(String navElementName){
        PageFactory.initElements(driver, CareerPage.class)
                .getSidebar().clickButton(navElementName)
                .getHeader().checkSection()
                .getHeader().checkTitle(navElementName)
                .getFooter().checkSection()
                .getFooter().checkElementsText();
    }

    static Stream<String> stringProvider(){
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @AfterEach
    protected void tearDown(){
        super.tearDown();
    }
}
