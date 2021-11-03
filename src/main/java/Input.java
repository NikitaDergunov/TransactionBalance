import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Scanner;

public class Input extends Thread{
    Scanner sc;
    Map<String,Money> money;
    public Input(InputStream in, Map<String,Money> money){
        sc = new Scanner(in);
        this.money = money;
    }

    @Override
    public void run() {
        try {
            while (sc.hasNext()&&!isInterrupted()) {
                String line = sc.nextLine();
                if (line.equals("quit")) break;
                else if (Helper.checkTransaction(line)) {
                    //check if we have a value:
                    Money moneyCurrent;
                    if ((moneyCurrent = money.get(Helper.getName(line))) == null) {
                        //create new money object
                        moneyCurrent = new Money(Helper.getName(line), Helper.getAmount(line));
                        if(Helper.checkExchange(line)) moneyCurrent.setExchange(Helper.getExchange(line));
                        //put money inside Map
                        money.put(moneyCurrent.getName(), moneyCurrent);
                        //create thread for that money

                    } else {
                        moneyCurrent.add(Helper.getAmount(line));
                    }
                } else System.out.println("Error in input!");
            }
        } finally {
            sc.close();
        }

    }
}
