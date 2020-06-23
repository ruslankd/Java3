package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOperations {

    private Integer [] array;

    public ArrayOperations() {
        this.array = new Integer[0];
    }

    public boolean setArray(Integer[] array) {
        if (array.length == 0) return false;
        this.array = array;
        return true;
    }

    public Integer[] arrayAfterFour() {
        if (!Arrays.asList(array).contains(4)) {
            throw new RuntimeException();
        }
        List<Integer> arrayHelper = new ArrayList<>();
        for (int i : array) {
            arrayHelper.add(i);
            if (i == 4) {
                arrayHelper.clear();
            }
        }
        return arrayHelper.toArray(new Integer[0]);
    }

    public boolean checkOneAndFour() {
        List<Integer> list = Arrays.asList(array);
        if (list.contains(1) && list.contains(4)) {
            for (Integer i : list) {
                if ((i != 1) && (i != 4)) return false;
            }
        } else return false;
        return true;
    }
}
