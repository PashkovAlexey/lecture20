package ru.exception;

public class CardNumberInvalidException extends Exception{

    private String cardNumber;

    public CardNumberInvalidException(String message, String cardNumber){
        super (message);
        this.cardNumber = cardNumber;

    }

    public String getCardNumber() {
        return cardNumber;
    }
}
