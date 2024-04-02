package Controller;

import Model.GarbageTruck;
import Model.Stations;
import View.ProgramView;

public class Controller {
    private ProgramView view;

    public Controller(ProgramView view) {
        this.view = view;
    }

    public int startProgram(String[] inputs) throws Exception {
        int[] temp = getInts(inputs);
        Stations stations = new Stations(temp.length);
        stations.setStation(temp);
        GarbageTruck garbageTruck = new GarbageTruck(0, 10000, 8, 30, 0, 0);

        for (int i = 0; i < stations.getStations().length; i++) {
            while (stations.getStations()[i].getGarbageAmmount() > 0) {
                int newGarbageAmmount = garbageTruck.loadGarbage(stations.getStations()[i].getGarbageAmmount());
                stations.getStations()[i].setGarbageAmmount(newGarbageAmmount);
            }
            // Final unload
            if (i == stations.getStations().length - 1) {
                garbageTruck.unloadGarbage();
            }
        }
        return garbageTruck.getTotalTimeSpent() * 120000 / 60 + garbageTruck.getTimeUnloaded() * 57000;
    }

    private int[] getInts(String[] inputs) throws Exception {
        int[] r = new int[inputs.length];
        try {
            for (int i = 0; i < inputs.length; i++) {
                r[i] = Integer.parseInt(inputs[i]);
            }
        } catch (Exception e) {
            throw new Exception("Inputs contains characters!");
        }

        return r;
    }

}
