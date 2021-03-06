package ru.geekbrains.atih.lesson04.example.junit.annotation.base;

import org.junit.jupiter.api.*;

public class BaseTest {
    @BeforeAll
    static void initAllBaseTests() {
        System.out.println("BaseTests initAll");
    }

    @BeforeEach
    void initBaseTests() {
        System.out.println("BaseTests init");
    }


    @AfterEach
    void tearDownBaseTests() {
        System.out.println("BaseTests tearDown");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("BaseTests tearDownAll");
    }
}
