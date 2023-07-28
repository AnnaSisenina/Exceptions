package seminar1.task2;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
        Необходимо посчитать и вернуть сумму элементов этого массива.
        При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
        (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
        Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
*/


import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        int[][] array = {{1,2}, {3,4}};
        int sum = sumOfElem(array);
        System.out.println(sum);
    }

    private static int sumOfElem(int[][] array) {
        if (array.length != array[0].length) throw new RuntimeException("It's not square array");
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0 && array[i][j] != 1) throw new RuntimeException("Array contains values different from 0 or 1");
                sum += array[i][j];
            }
        }
        return sum;
    }
}
