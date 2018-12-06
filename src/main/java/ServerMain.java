import server.*;

import java.net.Socket;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
    public static void main(String[] args) {
        //IStorage storage1 = new StorageFile("data");
        IStorage storage2 = new StorageBase("data/atm.db");
        Socketor socketor = new Socketor(8000);
        Context context = new Context();
        System.out.println("Laukiame klientu prisijungimo..");
        while (true) {
            socketor.accept();
            System.out.println("Klientas prisijunge");
            List<String> request = socketor.getRequest();
            String response = context.execute(storage2, request);
            socketor.sendResponse(response);
            socketor.closeClient();
            System.out.println(request.get(0));
           // System.out.println(request.get(1));
            System.out.println(response);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            //request.add("CreateCard");
            //request.add("CashIn");
            //request.add("626537");
            //request.add("1234");
            //request.add("5000");
        }

        //CardAction action = new CardAction();
        //Card card = action.create();
        //System.out.println(action.getBalance("655116","1234"));
        //System.out.println(action.changePin("009847","6966", "6967"));
        //System.out.println(action.cashOut("009847","6967", 100));
        //StrategyGetBalance action = new StrategyGetBalance();
        //StrategyChangePin action = new StrategyChangePin();
        // StrategyCreateCard action = new StrategyCreateCard();
        //StrategyCashOut action = new StrategyCashOut();
        // action.setStorage(storage2);
        //List<String> request = new ArrayList<>();
        //request.add("CreateCard");
        //request.add("CashOut");
        //request.add("626537");
        //request.add("1234");
        // request.add("5000");

        //String response = action.execute(request);
        // System.out.println(response);

        // Card copy = storage2.load(card.getNumber());
        //System.out.println(copy);
    }
}
