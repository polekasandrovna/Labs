
import java.math.BigDecimal;
import java.util.*;

public class AccountUtil {

    private AccountUtil() {
    }

    public static List<Account> generateAcc() {
        List<Account> acc = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            acc.add(new Account("Account" + i, BigDecimal.valueOf(Math.random() * 10000)));
        }

    return acc;
    }

}
