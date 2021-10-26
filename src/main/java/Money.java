import java.math.BigDecimal;

public class Money {
    private String name;
    private BigDecimal amount;
    //private BigDecimal exchange;
    public Money(String name){
        this.name = name;
        amount = BigDecimal.valueOf(0);
    }
    public Money(String name, BigDecimal amount){
        this.name = name;
        this.amount = amount;
    }
    public String getString(){
        return name + " " + amount.doubleValue();
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
}
