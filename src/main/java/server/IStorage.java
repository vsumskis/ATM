package server;

import java.util.List;

public interface IStorage {

    void save(Card card);

    Card load(String number);

    boolean exists(String number);

    void insertTransaciton(Transaction transaction);

    List<Transaction> loadTransactions(String number);
}
