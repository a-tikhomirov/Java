package ru.geekbrains.main.site.at;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;

@DisplayName("Проверка результатов поиска по ключевому слову Java")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SearchTest extends BaseTest{
    private Search searchPage;

    @BeforeAll
    protected void setUp(){
        super.setUpDriver();
        driver.get("https://geekbrains.ru/career");
        searchPage = PageFactory.initElements(driver, Page.class)
                .getHeader().clickSearch()
                .enterSearchText("Java");
    }

    @DisplayName("Проверка элементов")
    @ParameterizedTest(name = "{index} ==> Блок \"{0}\" условие \"{1}\"")
    @MethodSource("stringAndMatcherProvider")
    void checkSearchResults(String elementName, Matcher matcher){
        searchPage.checkElement(elementName, matcher);
    }

    Stream<Arguments> stringAndMatcherProvider(){
        return Stream.of(
                Arguments.of("Профессии", greaterThanOrEqualTo(2)),
                Arguments.of("Курсы", greaterThan(15)),
                Arguments.of("Вебинары", allOf(
                        greaterThan(180),
                        lessThan(300)
                )),
                Arguments.of("Блоги", greaterThan(300)),
                Arguments.of("Форумы", not(350)),
                Arguments.of("Тесты", not(0)),
                Arguments.of("Geekbrains", is(true))
        );
    }

    @AfterAll
    protected void tearDown(){
        super.tearDown();
    }
}
