import org.junit.Assert;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankTest {


    List<Account>  accs= null;

    //генеруємо аккаунти перед тестуванням
    @Before
    public void setUp(){
    accs = AccountUtil.generateAcc();
    }



    @org.junit.Test
    public void transfer() throws InterruptedException {

//получаємо загальну суму з усіх аккаунтів
        BigDecimal totalAmountOfMoneyBeforeRunning= Bank.getTotalAmountOfMoney(accs);

        //створюємо екземпляр класу Bank
        Bank bank = new Bank();
        //створюємо пул потоків
        ExecutorService executorService = Executors.newFixedThreadPool(500);

        //виконуємо 500 рандомних операцій(переказ грошей з одного рандомного аккаунта на інший,сума також рандомна)
        for (int i = 0; i <500 ; i++) {
            executorService.execute(() -> {
                Account from = accs.get((int) ( Math.random() * accs.size()) );
                Account to = accs.get((int) ( Math.random() * accs.size()) );
                BigDecimal amount = BigDecimal.valueOf((int)(Math.random() * from.getBalance().intValue()));

                bank.transfer(from,to, amount );
            });
            if (i==499){//коли виконались 499 операцій ,зупиняємо пул потоків
                executorService.shutdown();
            }
        }

       BigDecimal totalAmountOfMoneyAfterRunning =null;



        if (executorService.isShutdown()) {//якщо пул потоків призупинений,то получаємо загальну суму
            totalAmountOfMoneyAfterRunning = Bank.getTotalAmountOfMoney(accs);
        }
//порівнюємо чи після всіх переказів загальна сума усіх аккаунтів не помінялась
        Assert.assertEquals(totalAmountOfMoneyAfterRunning,totalAmountOfMoneyBeforeRunning);

    }
}