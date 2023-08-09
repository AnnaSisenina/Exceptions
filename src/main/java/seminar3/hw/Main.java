package seminar3.hw;
//�������� ����������, ������� ����� ����������� � ������������ ��������� ������ � ������������ �������, ����������� ��������:
// ������� ��� ��������, ���� ��������, ����� ��������, ���
// ������� ������:
// �������, ���, �������� - ������
// ���� �������� - ������ ������� dd.mm.yyyy
// ����� �������� - ����� ����������� ����� ��� ��������������
// ��� - ������ ��������� f ��� m.
// ���������� ������ ��������� ��������� ������ �� ����������.
// ���� ���������� �� ��������� � ���������, ������� ��� ������, ���������� ��� � �������� ������������ ���������, ��� �� ���� ������ � ������ ������, ��� ���������.
// ���������� ������ ���������� ���������� ���������� �������� � �������� �� ��� ��������� ���������.
// ���� ������� ������ �� ���������, ����� ������� ����������, ��������������� ���� ��������.
// ����� ������������ ���������� ���� java � ������� ����. ���������� ������ ���� ��������� ����������, ������������ �������� ��������� � �����������, ��� ������ �������.
// ���� �� ������� � ���������� �����, ������ ��������� ���� � ���������, ������ �������, � ���� � ���� ������ ������ ���������� ���������� ������, ����
// <�������><���><��������><������������> <�������������><���>
// ������������ ������ ���������� � ���� � ��� �� ����, � ��������� ������.
// �� �������� ������� ���������� � ������.
// ��� ������������� �������� � �������-������� � ����, ���������� ������ ���� ��������� ����������, ������������ ������ ������� ��������� ������.


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
                System.out.println("���� �� ������");
            }
        }
        else {
            try (FileWriter fw = new FileWriter(f)) {
                fw.write(userData[0] + " " + userData[1] + " " + userData[2] + " " + userData[3] + "\n");
            }catch (IOException e){
                System.out.println("���� �� ������");
            }
        }

    }

    private static String[] getData() throws Exceptions.InputDateException, Exceptions.InputPhoneNumberException, Exceptions.InputExcessDataException {
        System.out.println("""
                ������� ������:
                 ������� ��� ��������,
                 ���� �������� � ������� dd.mm.yyyy,
                 ����� �������� � ������� ������ ������������ �����,\s
                 ��� � ������� ������� ��������� f ��� m""");
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
            if (splitData[i].matches("^[�-��-�]*$")){
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


