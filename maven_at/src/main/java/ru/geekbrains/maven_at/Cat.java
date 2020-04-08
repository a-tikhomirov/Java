package ru.geekbrains.maven_at;

public class Cat implements Activity{
    private String name;
    private float maxRunDist;
    private float maxJumpHeight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(){
        name = "Cat";
        maxRunDist = 80;
        maxJumpHeight = 2;
    }

    public Cat(String name, float maxRunDist, float maxJumpHeight) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxJumpHeight = maxJumpHeight;
    }

    public boolean run(float dist) {
        return act("runs", dist, maxRunDist);
    }

    public boolean jump(float height) {
        return act("jumps", height, maxJumpHeight);
    }

    private boolean act(String activity, float request, float limit){
        boolean ableToDo = request <= limit;
        System.out.printf("%s %s for %.2f meters%s\n", name, activity, ableToDo? request : limit, ableToDo? "" : ". Can't do more...");
        return ableToDo;
    }
}
