public class Racetrack implements Obstacle{
    private String name;
    private float distance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public Racetrack(String name, float distance) {
        this.name = name;
        this.distance = distance;
    }

    public void getInfo() {
        System.out.printf("Passing an obstacle %s: distance = %.2f\n", name, distance);
    }

    public float getLimit() {
        return distance;
    }
}
