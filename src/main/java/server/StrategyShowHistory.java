package server;

import java.util.List;

public class StrategyShowHistory extends CardAction implements IStrategy {
    @Override
    public String execute(List<String> request) {
        String number = request.get(1);
        String pin = request.get(2);

        if (!isCardPinCorrect(number, pin))
            return error;
        return getTransactions(number);
    }

    private String getTransactions(String number) {
        List<Transaction> list = storage.loadTransactions(number);
        if (list.size() == 0)
            return "Tranzakciju sarasas yra tuscias";
        int nr = 1;
        String listString = "";
        for (Transaction transaction : list) {
            listString += nr++ + ". " + transaction + "/";
        }
        listString += "\n\n";
        return listString;
    }
}
