
package Model;

import java.util.Arrays;


public class Element {
    private int arraySize;
    private int[] array;

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return "Element{" + "arraySize=" + arraySize + ", array=" + Arrays.toString(array) + '}';
    }
    
    
}
