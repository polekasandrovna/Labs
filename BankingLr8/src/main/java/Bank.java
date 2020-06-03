import java.math.BigDecimal;
import java.util.*;
public class Bank {



    public  synchronized void transfer(Account from, Account to, BigDecimal amount) {
        if (from.getBalance().compareTo(amount)>0){
            from.withdraw(amount);
            to.deposite(amount);
        }
    }
   
public static BigDecimal getTotalAmountOfMoney(List<Account> list){
BigDecimal sum = new BigDecimal(0);

    for (Account acc : list
         ) {
        sum=sum.add(acc.getBalance());
    }
    return sum;
}

}
