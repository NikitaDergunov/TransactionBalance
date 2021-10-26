import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return exchangeset == money.exchangeset &&
                Objects.equals(name, money.name) &&
                Objects.equals(amount, money.amount) &&
                Objects.equals(exchange, money.exchange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, exchange, exchangeset);
    }
}
