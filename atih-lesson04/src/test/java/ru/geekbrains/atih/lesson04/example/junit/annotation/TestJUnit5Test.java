package ru.geekbrains.atih.lesson04.example.junit.annotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestJUnit5Test {
    //простой пример теста
    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}
