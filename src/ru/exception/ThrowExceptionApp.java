package ru.exception;

import java.util.Scanner;

public class ThrowExceptionApp {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер банковской карты");
        String cardNumber = sc.next();
        try {
         processCardNumber(cardNumber);
        } catch (CardNumberInvalidException e) {
            System.out.println(e.getMessage());
            System.out.println("Номер карты " + e.getCardNumber());
            processAccountNumber(sc);

        }

        System.out.println("Программа продолжает работу");

    }

    private static void processAccountNumber(Scanner sc) {
        System.out.println("Введите номер банковского счета");
        String accountNumber = sc.next();
        processAcctountNumber(accountNumber);
    }

    private static void processAcctountNumber(String accountNumber) {
        System.out.println("Ввели номер счета" + accountNumber);


    }

    private static void processCardNumber(String cardNumber) throws CardNumberInvalidException {

            if (cardNumber.length() > 16) {
                throw new CardNumberInvalidException("Введенный номер карты слишком длинный", cardNumber);
            } else if (cardNumber.length() < 16) {
                throw new CardNumberInvalidException("Введенный номер карты слишком короткий", cardNumber);
            }
            System.out.println("Вы вошли в систему по номеру карты" + cardNumber);

    }
}
