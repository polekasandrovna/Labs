public class Main {
    public static void main(String[] args) {

int threads = 10000;
        MonteCarlo monteCarlo = new MonteCarlo(threads);
Long timeBefore = System.currentTimeMillis();
double pi = monteCarlo.getPiByMonteCarloMethod();
Long timeAfter = System.currentTimeMillis();
        System.out.println("pi is = " + pi );
        System.out.println("Threads  = " + threads);
        System.out.println("Time is = "+(timeAfter-timeBefore) + " ms");

    }
}
