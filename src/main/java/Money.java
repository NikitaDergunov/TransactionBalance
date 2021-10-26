import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private String name;
    private BigDecimal amount;
    private BigDecimal exchange = null;
    private boolean exchangeset = false;
    public Money(String name){
        this.name = name;
        amount = BigDecimal.valueOf(0);
    }
    public Money(String name, BigDecimal amount){
        this.name = name;
        this.amount = amount;
    }
    public String getString(){
        if(!exchangeset) return name + " " + amount.doubleValue();
        else return name + " " + amount.doubleValue() + " (USD " + amount.multiply(exchange).doubleValue()+")";
    }
    public void add(BigDecimal n){

        amount = amount.add(n);
    }

    public String getName(){
        return name;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setExchange(BigDecimal exchange){
        exchangeset = true;
        this.exchange = exchange.divide(this.amount,6, RoundingMode.HALF_EVEN);
    }
}
