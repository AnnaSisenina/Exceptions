package seminar3.task3;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Exception {

    static class DivisionByZero extends ArithmeticException {

        public DivisionByZero() {
            super("������ �� ���� ������");
        }
    }
   static class NullElement extends NullPointerException {

       public NullElement() {
           super("�� ����������� � ��������������� ��������");
       }
   }
   static class FileNotExists extends FileNotFoundException {
       public FileNotExists() {
           super("�� ����������� � ��������������� �����");
       }
   }
}
