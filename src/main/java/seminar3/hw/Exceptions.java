package seminar3.hw;

import java.io.IOException;

public class Exceptions {

    static class InputDataException extends IOException{

        public InputDataException(int i){
            super("�������� ������ ������: ������ � " + i + " ������.*\n" +
                    "*\n" +
                    " 0. ���\n" +
                    " 1. ���� ��������\n" +
                    " 2. ����� ��������\n" +
                    " 3. ���\n" +
                    "������ �� ���������");
        }
    }

    static class InputExcessDataException extends IOException{
        public InputExcessDataException (int i) {
            super ("������� ������ ������ (" + i + " ���� ������ 6)" );
        }
    }

    static class InputDateException extends IOException{
        public InputDateException(){
            super("�� ����� ������������ ���� ��������, ������ �� ���������");
        }
    }
    static class InputPhoneNumberException extends IOException{
        public InputPhoneNumberException(){
            super("�� ����� ������������ ����� ��������, ������ �� ���������");
        }
    }
}
