package ru.io.basic;

import ru.io.basic.model.Person;

import java.io.*;
import java.util.Scanner;

public class DataOutputStreamApp {

    private static String FILE_NAME = "file/personDB3.txt";
    private static String CATALOG_NAME = "file/";

    public static void main(String[] args) {
        System.out.println("Записать данные или выгрузить в БД?");
        System.out.println("1. Загрузить");
        System.out.println("2. Выгрузить и отобразить");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            System.out.println("Заполните Person для сохранения");
            dbWrite(sc);
        } else if (choice == 2){
            dbRead(sc);
        }
    }
    private static void dbWrite(Scanner sc) {
        String personName = sc.next();
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(CATALOG_NAME + personName, true))) {
            dos.writeUTF(personName);
            dos.writeInt(sc.nextInt());
            dos.writeInt(sc.nextInt());
            dos.writeInt(sc.nextInt());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void dbRead(Scanner sc) {
        String personName = sc.next();
        try (DataInputStream dis = new DataInputStream(new FileInputStream(CATALOG_NAME + personName))) {
            Person p = new Person(dis.readUTF(), dis.readInt(), dis.readInt(), dis.readInt());
            System.out.println(p);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(personName + " - данная персона не найдена, введите ее повторно");
            dbRead(sc);
        }
    }
}
