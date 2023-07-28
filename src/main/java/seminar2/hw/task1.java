package seminar2.hw;
//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        inputPrintFloat();
    }

    private static void inputPrintFloat() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number");
        try {
            float number = sc.nextFloat();
            System.out.println(number);
        }
        catch (InputMismatchException e) {
            System.out.println(" It's not a number, try again");
            inputPrintFloat();
        }

    }
}
