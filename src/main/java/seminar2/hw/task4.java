package seminar2.hw;

import java.util.Scanner;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class task4 {
    public static void main(String[] args) {
        inputSmth();
    }

    private static void inputSmth() {
        System.out.println("Input smth");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.equals("")) throw new RuntimeException("You didn't input anything");
    }
}
