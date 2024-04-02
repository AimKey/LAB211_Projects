package Model;

public class GarbageTruck {

    private int currentCapacity, capacity, loadTime, transferTime, totalTimeSpent, timeUnloaded;

    public GarbageTruck() {
        this(0, 10000, 8, 30, 0, 0);
    }

    public GarbageTruck(
            int currentCapacity,
            int capacity,
            int loadTime,
            int transferTime,
            int totalTimeSpent,
            int timeUnloaded) {
        // Capacity in kgs
        this.currentCapacity = currentCapacity;
        this.capacity = capacity;
        // time in minutes
        this.loadTime = loadTime;
        this.transferTime = transferTime;
        this.totalTimeSpent = totalTimeSpent;
        // Number of times that this truck unloaded trash in landfill
        this.timeUnloaded = timeUnloaded;
    }

    public int loadGarbage(int loadAmount) throws Exception {
        int emptyCap = capacity - currentCapacity; // Space left for loading
        // Not full
        if (emptyCap >= loadAmount) {
            currentCapacity += loadAmount;
            totalTimeSpent += loadTime;
            return 0;
        } else {
            // full
            unloadGarbage();
            return loadAmount;
        }
    }

    public void unloadGarbage() throws Exception {
        // Transfer time
        totalTimeSpent += transferTime;
        // System.out.println("Chay toi bai... time spent: " + totalTimeSpent);
        this.timeUnloaded += 1;
        if (this.currentCapacity == 0)
            throw new Exception();
        this.currentCapacity = 0;
    }

    @Override
    public String toString() {
        System.out.println("Truck information:");
        return "Current garbage: " + currentCapacity + ", timeSpent: " + totalTimeSpent;
    }

    public int getTotalTimeSpent() {
        return totalTimeSpent;
    }

    public void setTotalTimeSpent(int totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    public int getTimeUnloaded() {
        return timeUnloaded;
    }

    public void setTimeUnloaded(int timeUnloaded) {
        this.timeUnloaded = timeUnloaded;
    }

}
