package ru.geekbrains.atih.lesson04.example.junit.annotation;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DisabledTest {

    @Disabled
    @Test
    void disabledTest() {
        assertEquals(2, 1 + 1);
    }
}
