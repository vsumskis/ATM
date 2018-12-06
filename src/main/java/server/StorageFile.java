package server;

import java.io.*;
import java.util.List;

public class StorageFile implements IStorage {

    private final String FOLDER;

    public StorageFile(String folder) {
        FOLDER = folder;
    }

    @Override
    public void save(Card card) {
        try (
                FileWriter writer = new FileWriter(getCardFilename(card));
        ) {
            writer.write(card.getNumber() + "\n");
            writer.write(card.getPin() + "\n");
            writer.write(card.getStatus() + "\n");
            writer.write(card.getExpires() + "\n");
            writer.write(card.getBalance() + "\n");
            writer.write(card.getPinErrors() + "\n");
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException("Korteles saugojimo klaida");
        }
    }

    @Override
    public Card load(String number) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(getCardFilename(number)));) {
            return new Card()
                    .setNumber(reader.readLine())
                    .setPin(reader.readLine())
                    .setStatus(CardStatus.valueOf(reader.readLine()))
                    .setExpires(reader.readLine())
                    .setBalance(Integer.parseInt(reader.readLine()))
                    .setPinErrors(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            throw new RuntimeException("Korteles duomenu skaitymo klaida");
        }
    }

    @Override
    public boolean exists(String number) {
        File file = new File(getCardFilename(number));
        return file.exists() && file.isFile();
    }

    private String getCardFilename(String number) {
        return FOLDER + "/cards/" + number;
    }

    private String getCardFilename(Card card) {
        return getCardFilename(card.getNumber());
    }

    @Override
    public void insertTransaciton(Transaction transaction) {
    }

    @Override
    public List<Transaction> loadTransactions(String number) {
        return null;
    }
}
