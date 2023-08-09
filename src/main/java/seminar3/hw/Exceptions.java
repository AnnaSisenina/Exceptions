package seminar3.hw;

import java.io.IOException;

public class Exceptions {

    static class InputDataException extends IOException{

        public InputDataException(int i){
            super("Неверный формат данных: ошибка в " + i + " строке.*\n" +
                    "*\n" +
                    " 0. ФИО\n" +
                    " 1. Дата рождения\n" +
                    " 2. Номер телефона\n" +
                    " 3. Пол\n" +
                    "Данные не сохранены");
        }
    }

    static class InputExcessDataException extends IOException{
        public InputExcessDataException (int i) {
            super ("Введены лишние данные (" + i + " слов вместо 6)" );
        }
    }

    static class InputDateException extends IOException{
        public InputDateException(){
            super("Вы ввели некорректную дату рождения, данные не сохранены");
        }
    }
    static class InputPhoneNumberException extends IOException{
        public InputPhoneNumberException(){
            super("Вы ввели некорректный номер телефона, данные не сохранены");
        }
    }
}
