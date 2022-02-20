package ru.io.basic;

import ru.io.basic.model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriterApp {

    private static String FILE_NAME = "file/personDB3.txt";
    private static String CATALOG_NAME = "file/";

    public static void main(String[] args) throws IOException {
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
    private static void dbWrite(Scanner sc) throws IOException {
        String personName = sc.next();
        try (FileWriter fw = new FileWriter(CATALOG_NAME + personName, true)) {
            fw.write("Name:" + sc.next() + " ");
            fw.write("Age:" + sc.nextInt() + " ");
            fw.write("ChildrenNumber:" + sc.nextInt()+ " ");
            fw.write( "WorkAge:" + sc.nextInt()+ " ");
            fw.write("\n");
            fw.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void dbRead(Scanner sc) {
        String fileName = sc.next();
        try (BufferedReader br = new BufferedReader(new FileReader(CATALOG_NAME + fileName))) {

            List<Person> listOfPerson = new ArrayList<>();

            String currentLine = "";
            while ((currentLine=br.readLine()) != null){
                System.out.println(currentLine);
                if(currentLine != null && !currentLine.isBlank()){
                    listOfPerson.add(convertStringToPerson(currentLine));
                }
            }
            System.out.println(listOfPerson);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println(fileName + " - данная персона не найдена, введите ее повторно");
            dbRead(sc);
        }

    }

    private static Person convertStringToPerson(String currentLine) {


        String[] splitted = currentLine.split(" ");
        Person person = new Person();

        for (String s : splitted){
            getNameAndSet(s, person);
            getAgeAndSet(s, person);
            getChildrenNumberAndSet(s, person);
            getWorkAgeAndSet(s, person);
        }
        return person;
    }

    private static void getNameAndSet(String s, Person p) {
        if (s != null && s.contains("Name")){
            p.setFio(s.split(":")[1]);
        }
    }

    private static void getAgeAndSet(String s, Person p) {
        if (s != null && s.contains("Age")){
            p.setAge(Integer.valueOf(s.split(":")[1]));
        }
    }

    private static void getChildrenNumberAndSet(String s, Person p) {
        if (s != null && s.contains("ChildrenNumber")){
            p.setChildren(Integer.valueOf(s.split(":")[1]));
        }
    }

    private static void getWorkAgeAndSet(String s, Person p) {
        if (s != null && s.contains("WorkAge")){
            p.setWorkAge(Integer.valueOf(s.split(":")[1]));
        }
    }


}
