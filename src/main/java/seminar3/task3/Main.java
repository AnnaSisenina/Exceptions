package seminar3.task3;
//�������� ����� ����������, ������� ����� ������������� ��� ������� �� 0. ���������� ������ ���������� �������� ��� ������������ ��������� �� ������.
//�������� ����� ����������, ������� ����� ��������� ��� ��������� � ������� �������� � ������� ���������� ����.
// ���������� ������ ���������� �������� ��� ������������ ��������� �� ������
//�������� ����� ����������, ������� ����� ��������� ��� ������� ������� �������������� ����.
// ���������� ������ ���������� �������� ��� ������������ ��������� �� ������.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception.FileNotExists {
        try {
            int a = 1, b = 5;
            int c = a/b;
        }
        catch (ArithmeticException ex){
            throw new Exception.DivisionByZero();
        }
        int i = 0;
        try {
            Integer [] array = {1 ,2, 4, 7};
            for (; i < array.length; i++) {
                System.out.println(array[i]);
                array[i]++;
            }

        }catch (NullPointerException ex){
            throw new Exception.NullElement();
        }
        String path = "jklwf.txt";
        try (FileReader fr = new FileReader(path)){
            int a = 5;
        }catch (FileNotFoundException ex){
            throw new Exception.FileNotExists();
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
