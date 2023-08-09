package seminar3.hw;
//Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
// Фамилия Имя Отчество, дата рождения, номер телефона, пол
// Форматы данных:
// фамилия, имя, отчество - строки
// дата рождения - строка формата dd.mm.yyyy
// номер телефона - целое беззнаковое число без форматирования
// пол - символ латиницей f или m.
// Приложение должно проверить введенные данные по количеству.
// Если количество не совпадает с требуемым, вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
// Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
// Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.
// Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
// <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
// Не забудьте закрыть соединение с файлом.
// При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.


import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)  {
        try {
            String [] userData = getData();
            checkUserData(userData);
            writeUserData(userData);
        } catch (Exceptions.InputExcessDataException | Exceptions.InputDataException |
                 Exceptions.InputPhoneNumberException | Exceptions.InputDateException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void checkUserData(String[] userData) throws Exceptions.InputDataException {

        for (int i = 0; i < userData.length; i++){
            if (userData[i] == null) throw new Exceptions.InputDataException(i);
        }
    }

    private static void writeUserData(String[] userData)  {
        String fileName = (userData[0].split(" "))[0];
        File f = new File("./Exceptions/src/main/java/seminar3/hw/" + fileName + ".txt");
        if (f.exists()){
            try (FileWriter fw = new FileWriter(f, true)) {
                fw.write(userData[0] + " " + userData[1] + " " + userData[2] + " " + userData[3] + "\n");
            }catch (IOException e){
                System.out.println("Файл не найден");
            }
        }
        else {
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(userData[0] + " " + userData[1] + " " + userData[2] + " " + userData[3] + "\n");
            }catch (IOException e){
                System.out.println("Файл не найден");
            }
        }

    }

    private static String[] getData() throws Exceptions.InputDateException, Exceptions.InputPhoneNumberException, Exceptions.InputExcessDataException {
        System.out.println("""
                Введите данные:
                 Фамилия Имя Отчество,
                 дата рождения в формате dd.mm.yyyy,
                 номер телефона в формате целого беззнакового числа,\s
                 пол в формате символа латиницей f или m""");
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        String[] splitData = data.split(" ");
        if (splitData.length > 6) throw new Exceptions.InputExcessDataException(splitData.length);
        String name = null;
        String birthDate = null;
        String phone = null;
        String gender = null;
        int checkName = 0;

        for (int i = 0; i < splitData.length; i++) {
            if (splitData[i].matches("^[а-яА-Я]*$")){
                checkName++;
                if (checkName == 3) {
                    name = splitData[i-2] + " " + splitData[i-1] + " " + splitData [i];
                    splitData[i-2] = null;
                    splitData[i-1] = null;
                    splitData[i] = null;
                    continue;
                }
            }
            else checkName = 0;
            if (splitData[i].matches("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d")){
                birthDate = splitData[i];
                checkBirthDate(birthDate);
                splitData[i] = null;
                continue;
            }
            if (splitData[i].matches("-?\\d+")){
                phone = splitData[i];
                checkPhone(phone);
                splitData[i] = null;
                continue;
            }
            if (splitData[i].equals("m") || (splitData[i].equals("f"))){
                gender = splitData[i];
                splitData[i] = null;
            }
        }
        String [] userInfo = new String[] {name, birthDate, phone, gender};

        System.out.println(name + " " + birthDate + " " + phone + " " + gender);
        return userInfo;
    }

    private static void checkBirthDate(String birthDate) throws Exceptions.InputDateException {
        String [] dates = birthDate.split("\\.");
        int [] intDates = new int [dates.length];
        for (int i = 0; i < intDates.length; i++)  {
            intDates[i] = Integer.parseInt(dates[i]);
        }
        LocalDate current_date = LocalDate.now();
        if (intDates[0] > 31 || intDates[0] < 1 ||
                intDates[1] > 12 || intDates[1] < 1 ||
                intDates[2] > current_date.getYear() || intDates[2] < 1900)
            throw new Exceptions.InputDateException();
    }

    private static void checkPhone(String phone) throws Exceptions.InputPhoneNumberException {
        if (phone.length()<9 || phone.length()>15) throw new Exceptions.InputPhoneNumberException();
    }
}


