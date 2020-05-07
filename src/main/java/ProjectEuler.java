import service.EulerProperties;
import service.EulerUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProjectEuler {

    public static void main(String[] args) {
        System.out.println("Starting Project Euler\n");
        init();
        System.out.println("Problem\tSolution");
        System.out.println("-------\t--------");
        System.out.println(solveProblem001());
        System.out.println(solveProblem002());
        System.out.println(solveProblem003());
    }

    private static String solveProblem001() {
        long startTime = System.nanoTime();

        final int MAX_VALUE = 1000, DIV1 = 3, DIV2 = 5;
        int sum = 0;
        for (int i = 1; i < MAX_VALUE; i++) {
            if (i % DIV1 == 0 | i % DIV2 == 0) {
                sum += i;
            }
        }

        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);  //Total execution time in milliseconds

        return "1\t\t" + sum + " (" + durationInMillis + " ms)";
    }

    private static String solveProblem002() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);  //Total execution time in milliseconds

        final int MAX_VALUE = 4_000_000;
        long d1 = 1, d2 = 2, sum;
        long total = d2; // Only even values
        while (true) {
            sum = d1 + d2;
            if(sum > MAX_VALUE) {
                break;
            }
            d1 = d2;
            d2 = sum;
            if(sum % 2 == 0) {
                total += sum;
            }
        }

        return "2\t\t" + total + " (" + durationInMillis + " ms)";
    }

    private static String solveProblem003() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);  //Total execution time in milliseconds

        BigInteger VALUE = BigInteger.valueOf(600_851_475_143L);
        List<Long> primes = EulerUtils.getPrimes(VALUE);

        return "3\t\t" + primes.get(primes.size() - 1) + " (" + durationInMillis + " ms)";
    }

    private static String solveProblem004() {
        long startTime = System.nanoTime();
        long endTime = System.nanoTime();
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);  //Total execution time in milliseconds

        // TODO: continue here

        return "3\t\t" + " (" + durationInMillis + " ms)";
    }

    private static void init() {
        try {
            EulerProperties mediaProperties = new EulerProperties();
        } catch (IOException e) {
            System.err.println("Error initializing EulerProperties: " + e.getMessage());
        }
    }
}
