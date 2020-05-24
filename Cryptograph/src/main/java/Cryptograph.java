

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cryptograph {


    private static String encrypt(String str) {

        StringBuilder encryptStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            encryptStr.append((char) ((int) str.charAt(i) + 1));

        }
        return encryptStr.toString();
    }

    private static String decrypt(String str) {

        StringBuilder decryptStr = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            decryptStr.append((char) ((int) str.charAt(i) - 1));

        }

        return decryptStr.toString();
    }

    //шифрує дані і записує у файл
    public static String  encryptDataAndWrite(String data, File file) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(encrypt(data));
            System.out.println("Дані було зашифровано та записано у файл");

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  encrypt(data);
    }


    public static String decryptDataAndWrite(File file) {
        FileReader fileReader = null;
        Scanner sc = null;
        StringBuilder encryptedData = new StringBuilder();
        try {
            fileReader = new FileReader(file);
            sc = new Scanner(fileReader);
            while (sc.hasNextLine()) {
                encryptedData.append(sc.nextLine());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return decrypt(encryptedData.toString());
    }


    public static void main(String[] args) {


        File file = new File("encryptData.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String data="Hello.My name is Polina.What is your name?";
        System.out.println("Вхідні дані : " + data);
        System.out.println("Шифруємо та записуємо дані у файл./nЗашифровані дані : " + encryptDataAndWrite(data,file));

        System.out.println("Зчитуємо дані з файла та розшифровуємо : ");

        System.out.println(decryptDataAndWrite(file));



    }
}
