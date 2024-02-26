package Model;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Employees extends ArrayList<Employee> {
    private String fileName;

    public Employees(String fileName) throws Exception {
        this.fileName = fileName;
        loadFile();
    }

    public void loadFile() throws Exception {
        Scanner sc = new Scanner(new FileReader(fileName));
        try {
            if (!new File(fileName).exists())
                throw new Exception("File at " + fileName + " not found!");
            while (sc.hasNextLine()) {
                String[] inputs = sc.nextLine().split(";");
                if (inputs[0] == "")
                    continue;
                if (inputs.length >= 3) {
                    this.add(new Employee(inputs[0], inputs[1], Double.parseDouble(inputs[2])));
                } else {
                    this.add(new Employee(inputs[0], inputs[1]));
                }
            }
        } finally {
            sc.close();
        }
    }
}
