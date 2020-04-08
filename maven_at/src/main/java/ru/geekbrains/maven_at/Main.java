package ru.geekbrains.maven_at;

public class Main {
    private static int TRACK = 0;
    private static int WALL = 1;

    public static void main(String[] args) {
        Human h = new Human();
        Cat c = new Cat("Barsik", 100, 3);
        Robot r = new Robot("Electronik", 10000, 5);

        Obstacle[][] obstacles = new Obstacle[4][2];
        for (int i = 1; i <= obstacles.length; ++i){
            obstacles[i-1][TRACK] = new Racetrack("Racetrack " + i, i * 80);
            obstacles[i-1][WALL] = new Wall("Wall " + i, i * 0.6f);
        }

        Sports[] sports = new Sports[3];
        sports[0] = new Sports(h);
        sports[1] = new Sports(c);
        sports[2] = new Sports(r);

        for (Obstacle[] o : obstacles){
            o[TRACK].getInfo();
            for (Sports s:sports){
                if (!s.isOut()) s.setOut(!s.act.run(o[0].getLimit()));
            }
            System.out.println();

            o[WALL].getInfo();
            for (Sports s:sports){
                if (!s.isOut()) s.setOut(!s.act.jump(o[1].getLimit()));
            }
            System.out.println();
        }
    }
}
