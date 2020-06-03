import java.math.BigDecimal;
import java.util.*;
public class Bank {


//метод для переводу грошей з одного акаунта на інший
    public  synchronized void transfer(Account from, Account to, BigDecimal amount) {
        if (from.getBalance().compareTo(amount)>0){
            from.withdraw(amount);
            to.deposite(amount);
        }
    }
    //метод для отримання загальної суми грошей  з усіх аккаунтів
public static BigDecimal getTotalAmountOfMoney(List<Account> list){
BigDecimal sum = new BigDecimal(0);

    for (Account acc : list
         ) {
        sum=sum.add(acc.getBalance());
    }
    return sum;
}

}
