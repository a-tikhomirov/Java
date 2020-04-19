package ru.geekbrains.atih.lesson04.example.junit.hamcrest.object;

public class Dog extends Animal {
    public Dog(String sound) {
        super(sound);
    }

    public String toString() {
        return this.sound;
    }
}
