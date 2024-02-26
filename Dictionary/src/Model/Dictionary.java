package Model;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary extends HashMap<String, String> {

    public Dictionary(String fileName) {
        this.loadFile(fileName);
    }

    public void loadFile(String fileName) {
        try {
            if (!new File(fileName).exists())
                throw new Exception("File at " + fileName + " not found!");
            Scanner sc = new Scanner(new FileReader(fileName));
            while (sc.hasNextLine()) {
                String[] inputs = sc.nextLine().split("-");
                if (inputs[0] == "")
                    continue;
                this.put(inputs[0], inputs[1]);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage() + ", initialize empty dictionary");
        }
    }

    public void doSave(String fileName) {
        System.out.println("Saving at " + fileName);
        File f = new File(fileName);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try (PrintWriter printWriter = new PrintWriter(new File(fileName))) {
            for (Map.Entry<String, String> set : this.entrySet()) {
                printWriter.println(set.getKey() + "-" + set.getValue());
            }
        } catch (Exception e) {
            System.out.println("\u001B[31m" + e.getMessage() + "\u001B[0m");
        }
    }
}
