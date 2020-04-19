package ru.geekbrains.atih.lesson04.example.junit.annotation;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("regress")
public class TagTest {
    @Tag("smoke")
    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Tag("extra")
    @Test
    void mySecondTest() {
        assertEquals(2, 1 + 2);
    }

    @Tag("blocked")
    @Test
    void myThirdTest() {
        assertEquals(2, 1 + 2);
    }
}
