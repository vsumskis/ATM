package server;

import java.util.List;

public class StrategyGetBalance extends CardAction implements IStrategy {

    @Override
    public String execute(List<String> request) {
        String number = request.get(1);
        String pin = request.get(2);

        if (!isCardPinCorrect(number, pin))
            return error;
        return "korteles likuits yra: " + card.getBalance() + " EUR";
    }

}
