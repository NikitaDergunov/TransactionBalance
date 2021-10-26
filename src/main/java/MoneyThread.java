import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyThread extends Thread{
    HashMap<String,Money>  monies;
    public MoneyThread(HashMap<String,Money> monies){
        this.monies=monies;
    }
    @Override
    public void run() {
        while (!isInterrupted()){
            try {
                Thread.sleep(6000);
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
