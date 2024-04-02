package Model;

import java.util.Arrays;

public class Stations {
    private Station[] stations;

    public Stations(int l) {
        stations = new Station[l];
    }

    public void setStation(int[] i) throws Exception {
        for (int j = 0; j < stations.length; j++) {
            if (i[j] > 10000)
                throw new Exception("Garbage truck cannot contain more than 10.000");
            stations[j] = new Station(i[j]);
        }
    }

    public boolean isAllClean() {
        for (Station station : stations) {
            if (station.getGarbageAmmount() > 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stations [stations=" + Arrays.toString(stations) + "]";
    }

    public Station[] getStations() {
        return stations;
    }

    public void setStations(Station[] stations) {
        this.stations = stations;
    }

}
