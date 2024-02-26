package Common;

public class Algorithm {

    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    public int partition(int[] array, int left, int right) {
        int i = left, j = right;
        int pivot = array[(left + right) / 2];
        int tmp;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
                j--;
            }
        };
        return i;
    }

    public void quickSort(int[] array, int left, int right) {
//        index == i
        int index = partition(array, left, right);
        if (left < index - 1) {
            quickSort(array, left, index - 1);
        }
        if (index < right) {
            quickSort(array, index, right);
        }
    }

    public int linearSearch(int[] array, int item) {
        int temp = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                temp = i;
                break;
            }
        }
        return temp;
    }

    public int binarySearch(int[] array, int item) {
        int left = 0;
        int len = array.length - 1;
        while (left <= len) {
            int middle = left + (len - left) / 2;
            if (array[middle] == item) return middle;
            else if (array[middle] < item) left = middle + 1;
            else len = middle - 1;
        }
        return -1;
    }

}
