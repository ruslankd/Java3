package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MyArray<T> {

    private T[] array;

    public MyArray(T ... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void swapInArray(int firstIndex, int secondIndex) {
        T element = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = element;
    }

    public ArrayList<T> toArrayList() {
        return new ArrayList<>(Arrays.asList(array));
    }

    @Override
    public String toString() {
        return "MyArray{" +
                "array = " + Arrays.toString(array) +
                '}';
    }
}
