package ru.io;

import java.io.File;
import java.io.IOException;

public class FileAPP {
    public static void main(String[] args) throws IOException {
        File f = new File("file/personDB.txt");
        if (f.exists()){
            File parentDir = new File(f.getParent());
            MyFileNameFilter filter = new MyFileNameFilter();
            for (File cur : parentDir.listFiles(filter)){
                System.out.println(cur.getName());
                if (cur.isDirectory()){
                    System.out.println ("Представлен каталог");
                } else {
                    System.out.println ("Представлен файл");

                }

            }
        } else {
            System.out.println("File created: " + f.getName());
            f.createNewFile();

        }


    }
}
