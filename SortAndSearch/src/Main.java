
import Common.Library;
import Controller.SortingProgram;
import Model.Element;

public class Main {

    public static void main(String[] args) {
        Library library = new Library();
        Element element = new Element();
        element.setArraySize(library.getInt("Enter the ammount of elements in array"));
        element.setArray(library.createRandomArray(element.getArraySize()));
        new SortingProgram(element).run();
    }
}
