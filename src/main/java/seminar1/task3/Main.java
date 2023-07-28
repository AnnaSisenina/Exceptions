package seminar1.task3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {3, null, 5, 6, null};
        checkArray(array);
    }

    public static void checkArray(Integer[] arr){
        ArrayList<Integer> errors = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) errors.add(i);
        }
        if (!errors.isEmpty()) {
            throw new RuntimeException("Index of null элементы: " + errors);
        }
    }
}
