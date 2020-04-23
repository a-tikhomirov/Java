package ru.geekbrains.example.junit.annotation;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@Tag("regress")
class TagTest {

    @Tag("smoke")
    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}

//<plugin>
//    <groupId>org.apache.maven.plugins</groupId>
//    <artifactId>maven-surefire-plugin</artifactId>
//    <version>2.22.1</version>
//    <configuration>
//        <includes>
//            <include>**/*Test*.java</include>
//        </includes>
//        <groups>regress | smoke</groups>
//        <excludedGroups>extra, blocked</excludedGroups>
//    </configuration>
//</plugin>