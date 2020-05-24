import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MonteCarloTest {


    int amountOfThreads=0;
    MonteCarlo monteCarlo =null;

@Before
public void setUp(){
    amountOfThreads=100000;
   monteCarlo= new MonteCarlo(amountOfThreads);

}

    @Test
    public void getPi() {
        double pi = monteCarlo.getPiByMonteCarloMethod();
        Assert.assertEquals(3,(int)pi);
    }
}