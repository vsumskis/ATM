package server;

public class Card {

    private String number;
    private String pin;
    private CardStatus status;
    private String expires;
    private int balance;
    private int pinErrors;

    public String getNumber() {
        return number;
    }

    Card setNumber(String number) {
        this.number = number;
        return this;
    }

    String getPin() {
        return pin;
    }

    Card setPin(String pin) {
        this.pin = pin;
        return this;
    }

    CardStatus getStatus() {
        return status;
    }

    Card setStatus(CardStatus status) {
        this.status = status;
        return this;
    }

    String getExpires() {
        return expires;
    }

    Card setExpires(String expires) {
        this.expires = expires;
        return this;
    }

    int getBalance() {
        return balance;
    }

    Card setBalance(int balance) {
        this.balance = balance;
        return this;
    }

    int getPinErrors() {
        return pinErrors;
    }

    Card setPinErrors(int pinErrors) {
        this.pinErrors = pinErrors;
        return this;
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", status=" + status +
                ", expires='" + expires + '\'' +
                ", balance=" + balance +
                ", pinErrors=" + pinErrors +
                '}';
    }
}
