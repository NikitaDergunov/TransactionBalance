import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTests {
    @Test
    public void testMoney(){
        BigDecimal big = BigDecimal.valueOf(10);

        Money money = new Money("RUB", big);
        big.add(BigDecimal.valueOf(1));
        money.add(BigDecimal.valueOf(1));
        Assert.assertEquals(big,money.getAmount());
    }
    @Test
    public void testBigD(){
        String input = "-9";
        BigDecimal inputBD = BigDecimal.valueOf(-9);
        Assert.assertEquals(BigDecimal.valueOf(Double.parseDouble(input)),inputBD);
    }
    @Test
    public void testAdd(){
        String input = "-9";
        BigDecimal inputBD = BigDecimal.valueOf(-9);
        BigDecimal big = BigDecimal.valueOf(10);
        Money money = new Money("RUB", big);
        BigDecimal big2 = BigDecimal.valueOf(10);
        money.add(inputBD);
        big2.add(inputBD);
        Assert.assertEquals(big2,money.getAmount());
    }
}
