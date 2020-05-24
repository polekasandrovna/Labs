

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class MonteCarlo {

    private AtomicInteger nAtomSuccess;
    private int nThrows;
    private double value;

    public MonteCarlo(int amountOfThreads) {
        this.nAtomSuccess = new AtomicInteger(0);
        this.nThrows = amountOfThreads;
        this.value = 0;
    }
    public double getPiByMonteCarloMethod() {
        int nProcessors = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newWorkStealingPool(nProcessors);
        for (int i = 1; i <= nThrows; i++) {
            Runnable worker = () -> {
                double x = Math.random();
                double y = Math.random();
                if (x * x + y * y <= 1)
                    nAtomSuccess.incrementAndGet();
            };
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        value = 4.0 * nAtomSuccess.get() / nThrows;
        System.out.println("Iteration : "+nAtomSuccess);
        return value;
    }
}
