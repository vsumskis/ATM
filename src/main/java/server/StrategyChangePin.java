package server;

import java.util.List;

public class StrategyChangePin extends CardAction implements IStrategy {
    @Override
    public String execute(List<String> request) {

        String number = request.get(1);
        String oldPin = request.get(2);
        String newPin = request.get(3);

        if (!isCardPinCorrect(number, oldPin))
            return error;

        if (!newPin.matches("^[0-9]{4}$"))
            return "Naujas pin kodas turi susideti is 4 skaitmenu";
        card.setPin(newPin);
        storage.save(card);
        createTransaction(TransactionType.CHANGE_PIN, null);
        return "Pin kodas pakeistas";
    }
}
