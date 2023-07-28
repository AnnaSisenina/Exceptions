package seminar2.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        writeFromArr(change(readToArr("./text.txt")), "./text.txt");

    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static List<String []> readToArr (String filePatch){

        List <String []> str = new ArrayList<>();
        try{
            FileReader file = new FileReader(filePatch);
            BufferedReader BufReader = new BufferedReader(file);
            String line;

            while((line = BufReader.readLine()) != null)
                str.add(line.split("="));

            // for (String[] strings : str) {
            //     System.out.println(String.join("", strings));
            // }

        }
        catch (IOException e){
            System.out.println("Ошибка пути файла " + filePatch);
        }

        return str;
    }

    public static List <String []> change(List <String []> str){

        for (String[] strings : str) {

            if (!strings[1].equals("?") && !isNumeric(strings[1])){
                throw new RuntimeException("Не число");
            }
            else if (strings[1].equals("?")) {
                strings[1] = Integer.toString(strings[0].length());
            }


        }

        return str;
    }

    public static boolean writeFromArr(List <String []> str, String filePatch){

        try{
            FileWriter file = new FileWriter(filePatch);
            BufferedWriter BufWriter = new BufferedWriter(file);

            for (String[] strings : str) {
                BufWriter.write(strings[0] + "=" + strings[1]);
                BufWriter.newLine();
            }
            BufWriter.close();

            return true;
        }
        catch (IOException e){
            System.out.println("Ошибка пути файла " + filePatch);
            return false;
        }

    }
}
