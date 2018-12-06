package server;

import java.util.List;

public class StrategyCashIn extends CardAction implements IStrategy {
    @Override
    public String execute(List<String> request) {

        String number = request.get(1);
        String pin = request.get(2);
        int amount = Integer.parseInt(request.get(3));

        if (!isCardPinCorrect(number, pin))
            return error;
        if (amount <= 0)
            return "Pinigu suma turi buti didesne uz 0";
        card.setBalance(card.getBalance() + amount);
        storage.save(card);
        createTransaction(TransactionType.CASH_IN,String.valueOf(amount));

        return "Suma inesta: " + amount;

    }
}
