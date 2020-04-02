public class Main {
    public static void main(String[] args) {
        Human h = new Human();
        Cat c = new Cat("Barsik", 100, 3);
        Robot r = new Robot("Electronik", 10000, 5);

        /*
        float toRun = 200;
        float toJump = 3;

        h.run(toRun);
        h.jump(toJump);

        c.run(toRun);
        c.jump(toJump);

        r.run(toRun);
        r.jump(toJump);
        */

        Obstacle[][] obstacles = new Obstacle[4][2];
        for (int i = 1; i <= obstacles.length; ++i){
            obstacles[i-1][0] = new Racetrack("Racetrack " + i, i * 80);
            obstacles[i-1][1] = new Wall("Wall " + i, i * 0.6f);
        }

        Sports[] sports = new Sports[3];
        sports[0] = new Sports(h);
        sports[1] = new Sports(c);
        sports[2] = new Sports(r);

        for (Obstacle[] o : obstacles){
            o[0].pass();
            for (Sports s:sports){
                if (!s.isOut()) s.setOut(!s.act.run(o[0].getLimit()));
            }
            System.out.println();

            o[1].pass();
            for (Sports s:sports){
                if (!s.isOut()) s.setOut(!s.act.jump(o[1].getLimit()));
            }
            System.out.println();
        }
    }
}
