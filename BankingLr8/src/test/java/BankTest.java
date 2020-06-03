import org.junit.Assert;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankTest {


    List<Account>  accs= null;

    
    @Before
    public void setUp(){
    accs = AccountUtil.generateAcc();
    }



    @org.junit.Test
    public void transfer() throws InterruptedException {


        BigDecimal totalAmountOfMoneyBeforeRunning= Bank.getTotalAmountOfMoney(accs);

        
        Bank bank = new Bank();
       
        ExecutorService executorService = Executors.newFixedThreadPool(500);

        
        for (int i = 0; i <500 ; i++) {
            executorService.execute(() -> {
                Account from = accs.get((int) ( Math.random() * accs.size()) );
                Account to = accs.get((int) ( Math.random() * accs.size()) );
                BigDecimal amount = BigDecimal.valueOf((int)(Math.random() * from.getBalance().intValue()));

                bank.transfer(from,to, amount );
            });
            if (i==499){
                executorService.shutdown();
            }
        }

       BigDecimal totalAmountOfMoneyAfterRunning =null;



        if (executorService.isShutdown()) {
            totalAmountOfMoneyAfterRunning = Bank.getTotalAmountOfMoney(accs);
        }

        Assert.assertEquals(totalAmountOfMoneyAfterRunning,totalAmountOfMoneyBeforeRunning);

    }
}
