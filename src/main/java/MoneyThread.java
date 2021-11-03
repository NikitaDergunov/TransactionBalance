import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MoneyThread extends Thread{
    Map<String,Money>  monies;
    public MoneyThread(Map<String,Money> monies){
        this.monies=monies;
    }
    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                break;
            }
            for(Map.Entry<String,Money> m : monies.entrySet()){
            if(!m.getValue().getAmount().equals(BigDecimal.valueOf(0.0))){
            System.out.println(m.getValue().getString());
            }
            }
        }
    }
}
