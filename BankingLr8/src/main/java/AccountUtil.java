
import java.math.BigDecimal;
import java.util.*;

public class AccountUtil {

    private AccountUtil() {
    }
//метод для генерації аккаунтів
//повертає 1000 створенних аккаунтів
    public static List<Account> generateAcc() {
        List<Account> acc = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {//даний цикл створює 1000 аккаунтів
            acc.add(new Account("Account" + i, BigDecimal.valueOf(Math.random() * 10000)));
        }

    return acc;
    }

}
