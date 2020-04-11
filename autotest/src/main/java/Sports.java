public class Sports {
    public Activity act;
    private boolean isOut;

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public Sports(Activity a) {
        isOut = false;
        this.act = a;
    }
}
