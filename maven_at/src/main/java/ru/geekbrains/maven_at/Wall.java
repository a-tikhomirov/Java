package ru.geekbrains.maven_at;

public class Wall implements Obstacle{
    private String name;
    private float height;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Wall(String name, float height) {
        this.name = name;
        this.height = height;
    }

    public void getInfo() {
        System.out.printf("Passing an obstacle %s: height = %.2f\n", name, height);
    }

    public float getLimit() {
        return height;
    }
}
