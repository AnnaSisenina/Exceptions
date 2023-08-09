package seminar3.task4;

public class Exception {
     static class MyArraySizeException extends RuntimeException{

        public MyArraySizeException() {
            super("Недопустимый размер массива");
        }
        public MyArraySizeException(int row, int colum) {
            super("Недопустимый размер массива, размер введенного массива: " + row + "x" + colum);
        }

    }
    public static class MyArrayDataException extends NumberFormatException{

        public MyArrayDataException() {
            super("Недопустимый тип данных");
        }
        public MyArrayDataException(int i, int j) {
            super("Недопустимый тип данных в ячейке: "+ i + "x" + j);
        }
    }
}
