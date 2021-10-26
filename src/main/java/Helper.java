import java.math.BigDecimal;
// Utility class
public class Helper {
    public static boolean checkTransaction(String transaction){
        boolean ans1 = true;
        boolean ans2 = true;
        boolean ans3 = true;
        String[] array = transaction.split(" ");
        //1 space check
        ans1 = array.length == 2;
        //Array index oob
        if(ans1){
            //currency name format check
        ans2 = array[0].matches("[A-Z][A-Z][A-Z]");
        //signed integer check
        ans3 = array[1].matches("^(\\+|-)?\\d+$");
        return ans1&&ans2&&ans3;
        }
        else return false;
    }
    public static String getName(String transaction){
        return transaction.substring(0,3);
    }
    public static BigDecimal getAmount(String transaction){
        String[] s = transaction.split(" ");
        BigDecimal ans = BigDecimal.valueOf(Double.parseDouble(s[1]));
        return ans;
    }
}
