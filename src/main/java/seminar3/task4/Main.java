package seminar3.task4;
//Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
// При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
// Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
// должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
//В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException
// и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
public class Main {
    public static void main(String[] args) {
        String [][] array = new String[][]{{"23", "23", "12", "1"},{"23", "4", "12", "12"},{"23", "23", "12", "12"},{"23", "23", "12", "12"}};
         int sum = sumArray(array);
        System.out.println(sum);
    }

    private static int sumArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) throw new Exception.MyArraySizeException(array.length, array[0].length);
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new Exception.MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }
}
