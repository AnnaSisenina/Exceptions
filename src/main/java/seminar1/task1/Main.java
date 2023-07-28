package seminar1.task1;
/*
Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение. Метод ищет в массиве
заданное значение и возвращает его индекс. При этом, например:
        если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
        если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
        если вместо массива пришел null, метод вернет -3
        придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
        Напишите метод, в котором реализуйте взаимодействие с пользователем. То есть, этот метод запросит искомое число
        у пользователя, вызовет первый, обработает возвращенное значение и покажет читаемый результат пользователю.
        Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.

 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] array = new int[] {1, 2, 3, 4, 5};
        System.out.println("Input number ");
        Scanner scanner = new Scanner(System.in);
        int element = scanner.nextInt();
        int indexElem = findElementInArray(array, element);
        exceptionResult(indexElem);
    }

    private static void exceptionResult(int indexElem) {
        switch (indexElem) {
            case -3:
                System.out.println("Array is null");
                break;
            case -2:
                System.out.println("Element not founded");
                break;
            case -1:
                System.out.println("Array length is less than 3");
                break;
            default:
                System.out.println("Index of element " + indexElem);
        }
    }

    private static int findElementInArray(int[] array, int elem) {
        if (array == null) return -3;
        if (array.length < 3) return -1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elem) return i;
        }
        return -2;
    }
}
