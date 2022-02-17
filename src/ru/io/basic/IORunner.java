package ru.io.basic;

import ru.io.FileAPP;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class IORunner {

    public static void main(String[] args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            Scanner sc = new Scanner(System.in);
            File f = new File("file/personDB.txt");

            fr = new FileReader(f);
            StringBuffer s = new StringBuffer();

            int i = 0;
            while ((i = fr.read()) != -1){
                s.append((char)i);
            }
            System.out.println(s);

            File f2 = new File("file/personDB2.txt");
            if (f2.exists()) f2.createNewFile();

            fw = new FileWriter(f2, true);
            fw.append(sc.nextLine());

            fw.flush();

            System.out.println("Работа завершена успешно");

        } catch (Exception e) {
            e.printStackTrace();

            System.out.println("Мы поймали ошибку");

        } finally {
            System.out.println("Всегда исполняюсь");
            fr.close();
            fw.close();
        }
    }


}
