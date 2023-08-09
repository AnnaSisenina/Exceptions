package seminar3.task4;

public class Exception {
     static class MyArraySizeException extends RuntimeException{

        public MyArraySizeException() {
            super("������������ ������ �������");
        }
        public MyArraySizeException(int row, int colum) {
            super("������������ ������ �������, ������ ���������� �������: " + row + "x" + colum);
        }

    }
    public static class MyArrayDataException extends NumberFormatException{

        public MyArrayDataException() {
            super("������������ ��� ������");
        }
        public MyArrayDataException(int i, int j) {
            super("������������ ��� ������ � ������: "+ i + "x" + j);
        }
    }
}
