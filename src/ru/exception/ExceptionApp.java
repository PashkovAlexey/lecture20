package ru.exception;

public class ExceptionApp {
    public static void main(String[] args) {
        System.out.println("Начало работы программы");
        populateArray();
        System.out.println("Конец работы программы");
    }

    private static void populateArray() {
        int[] numbers = null; /*new int[3];*/
        try {
            numbers[3] = 45;
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException number 1");
            e.printStackTrace();
            try {
                System.out.println(numbers[3]);
            } catch (Exception e2) {
                e2.printStackTrace();
                System.out.println("ArrayIndexOutOfBoundsException number 2");
            }
        } catch (NullPointerException e3){
            System.out.println("NullPointerException");
            e3.printStackTrace();
        } catch (Exception e2){
            System.out.println("Exception");
            e2.printStackTrace();
        } finally {
            System.out.println("Я всегда выполняюсь");
        }
        System.out.println("Вывод вне блока try catch");
    }

}
