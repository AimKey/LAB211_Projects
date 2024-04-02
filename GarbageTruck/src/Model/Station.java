package Model;

public class Station {
    private int garbageAmmount;

    public Station(int garbageAmmount) {
        this.garbageAmmount = garbageAmmount;
    }

    public int getGarbageAmmount() {
        return garbageAmmount;
    }

    public void setGarbageAmmount(int garbageAmmount) {
        this.garbageAmmount = garbageAmmount;
    }

    @Override
    public String toString() {
        return String.valueOf(garbageAmmount);
    }

}
