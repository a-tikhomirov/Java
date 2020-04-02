public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        Cat c = new Cat("Barsik", 100, 3);
        Robot r = new Robot("Electronik", 10000, 5);

        float toRun = 200;
        float toJump = 3;

        h.run(toRun);
        h.jump(toJump);

        c.run(toRun);
        c.jump(toJump);

        r.run(toRun);
        r.jump(toJump);
    }
}
