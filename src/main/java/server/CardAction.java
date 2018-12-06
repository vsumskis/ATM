package server;

//import java.util.Random;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CardAction {

    protected Card card;
    protected IStorage storage;
    protected String error;
    protected Transaction transaction;


    public void setStorage(IStorage storage) {
        this.storage = storage;
    }

    public String isCardValid(String number) {
        if (!storage.exists(number))
            return "Korteles numeris nerastas!";
        card = storage.load(number);
        if (card.getStatus() == CardStatus.BLOCKED)
            return "Kortele uzblokuota!";
        checkExpired();
        if (card.getStatus() == CardStatus.EXPIRED)
            return "Korteles galiojimo laikas pasibaige";
        if (card.getStatus() == CardStatus.ACTIVE)
            return "ok";
        return "Korteles busena nenustatyta";
    }

    private void checkExpired() {
        if (card.getStatus() != CardStatus.ACTIVE)
            return;
        Calendar calendar = Calendar.getInstance();
        String today = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(calendar.getTime());
        if (today.compareTo(card.getExpires()) >= 0) {
            card.setStatus(CardStatus.EXPIRED);
            storage.save(card);
        }
    }

    private boolean checkPin(String pin) {
        if (card.getPin().equals(pin)) {
            if (card.getPinErrors() > 0) {
                card.setPinErrors(0);
                storage.save(card);
            }
            return true;
        }
        int pinerrors = card.getPinErrors() + 1;
        card.setPinErrors(pinerrors);
        if (pinerrors >= 3)
            card.setStatus(CardStatus.BLOCKED);
        storage.save(card);
        return false;
    }

    protected boolean isCardPinCorrect(String number, String pin) {
        error = isCardValid(number);
        if (!error.equals("ok"))
            return false;
        if (checkPin(pin))
            return true;
        error = "Pin kodas ivestas neteisingai: " + card.getBalance();
        return false;
    }

     void createTransaction(TransactionType transactiontype, String amount) {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
         transaction = new Transaction()
                .setActionDate(timeStamp)
                .setNumber(card.getNumber())
                .setTransactionType(transactiontype)
                .setAmount(amount);
        storage.insertTransaciton(transaction);

    }
}