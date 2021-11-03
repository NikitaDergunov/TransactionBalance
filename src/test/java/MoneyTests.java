import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyTests {
    @Test
    public void testMoney(){
        BigDecimal big = BigDecimal.valueOf(70);

        Money money = new Money("RUB", big);
        money.setExchange(BigDecimal.valueOf(1.2d));
        System.out.println(money.getString());
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
    @Test
    public void testHelperEx(){
        String[] s1 ={
                "EUR 100 (USD 110.67)"
               };
        for(String s : s1){
        Assert.assertEquals(true,Helper.checkExchange(s));}
    }
    @Test
    public void  testGetEx(){
        String s1 = "RUB 73 (USD 1)";
        BigDecimal bigDecimal = BigDecimal.valueOf(1d);
        Assert.assertEquals(Helper.getExchange(s1),bigDecimal);
    }
}
