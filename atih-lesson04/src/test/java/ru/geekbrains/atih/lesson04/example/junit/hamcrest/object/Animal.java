package ru.geekbrains.atih.lesson04.example.junit.hamcrest.object;

public class Animal {
    protected String sound;

    public Animal(String sound) {
        this.sound = sound;
    }


    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
