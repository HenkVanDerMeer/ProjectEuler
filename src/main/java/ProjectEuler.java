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
        System.out.println("Problem\tTime (ms)\tSolution");
        System.out.println("-------\t---------\t--------");
        for (int problemNr = 1; problemNr <= 10; problemNr++) {
            System.out.println(solveProblem(problemNr));
        }
    }

    private static String solveProblem(int problemNr) {
        long startTime = System.nanoTime();
        String solution = "";

        // Solutions
        switch (problemNr) {
            case 1: {
                int sum = 0;
                final int MAX_VALUE = 1000, DIV1 = 3, DIV2 = 5;
                for (int i = 1; i < MAX_VALUE; i++) {
                    if (i % DIV1 == 0 | i % DIV2 == 0) {
                        sum += i;
                    }
                }
                solution = String.valueOf(sum);
                break;
            }
            case 2: {
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
                solution = String.valueOf(total);
                break;
            }
            case 3: {
                BigInteger VALUE = BigInteger.valueOf(600_851_475_143L);
                List<Long> primes = EulerUtils.getPrimes(VALUE);
                solution = String.valueOf(primes.get(primes.size() - 1));
                break;
            }
            case 4: {
                final int MAX_VALUE = 999; // Max 3-digit number
                final int MIN_VALUE = 100; // Min 3-digit number
                int maxProduct = 0;
                for(int i = MAX_VALUE; i >= MIN_VALUE; i--) {
                    int j = EulerUtils.getLargestPalindrome(i);
                    if (i * j > maxProduct) {
                        maxProduct = i * j;
                    }
                }
                solution = String.valueOf(maxProduct);

                break;
            }
            case 5: {
                final int DIVIDER = 20;
                int value = DIVIDER;
                while(true) {
                    if(EulerUtils.isDivisible(value, DIVIDER)) {
                        break;
                    } else {
                        value++;
                    }
                }
                solution = String.valueOf(value);
                break;
            }
            case 6: {
                int squareSum = 0;
                int sumSquare = 0;
                for (int i = 1; i <= 100; i++) {
                    squareSum += (i*i);
                    sumSquare += i;
                }
                sumSquare *= sumSquare;
                solution = String.valueOf(sumSquare - squareSum);
                break;
            }
            case 7: {
                final int COUNT = 10001;
                int count = 0;
                BigInteger prime = BigInteger.ZERO;
                while (count < COUNT) {
                    prime = prime.nextProbablePrime();
                    count++;
                }
                solution = String.valueOf(prime);
                break;
            }
            case 8: {
                final int COUNT = 13;
                String digits = "73167176531330624919225119674426574742355349194934" +
                        "96983520312774506326239578318016984801869478851843" +
                        "85861560789112949495459501737958331952853208805511" +
                        "12540698747158523863050715693290963295227443043557" +
                        "66896648950445244523161731856403098711121722383113" +
                        "62229893423380308135336276614282806444486645238749" +
                        "30358907296290491560440772390713810515859307960866" +
                        "70172427121883998797908792274921901699720888093776" +
                        "65727333001053367881220235421809751254540594752243" +
                        "52584907711670556013604839586446706324415722155397" +
                        "53697817977846174064955149290862569321978468622482" +
                        "83972241375657056057490261407972968652414535100474" +
                        "82166370484403199890008895243450658541227588666881" +
                        "16427171479924442928230863465674813919123162824586" +
                        "17866458359124566529476545682848912883142607690042" +
                        "24219022671055626321111109370544217506941658960408" +
                        "07198403850962455444362981230987879927244284909188" +
                        "84580156166097919133875499200524063689912560717606" +
                        "05886116467109405077541002256983155200055935729725" +
                        "71636269561882670428252483600823257530420752963450";
                BigInteger newProduct;
                BigInteger maxProduct = BigInteger.ZERO;
                for (int i = 0; i < digits.length() - COUNT + 1; i++) {
                    newProduct = EulerUtils.getProduct(digits.substring(i, i + COUNT));
                    maxProduct = maxProduct.max(newProduct);
//                    System.out.println(i + 1 + "\t" + substring + "\t" + newProduct + "\t" + maxProduct);
                }
                solution = String.valueOf(maxProduct);
                break;
            }
            case 9: {
                // Find first solution - brute force
                final int SUM = 1000;
                for (int a = 0; a < SUM; a++) {
                    for (int b = 0; b < SUM; b++) {
                        for (int c = 0; c < SUM; c++) {
                            if ((a*a + b*b == c*c) && (a + b + c == SUM) && a < b && b < c) {
//                                System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                                solution = String.valueOf(a * b * c);
                            }
                        }
                    }
                }
                break;
            }
            case 10: {
                final int MAX = 2_000_000;
                BigInteger primeSum = BigInteger.ZERO;
                BigInteger prime = BigInteger.ZERO;

                do {
                    prime = prime.nextProbablePrime();
                    primeSum = primeSum.add(prime);
//                    System.out.println(prime + "\t" + primeSum);
                } while (!prime.equals(prime.max(BigInteger.valueOf(MAX))));

                solution = String.valueOf(primeSum.subtract(prime));
                break;
            }
            default: {
                solution = "Unknown problem";
                break;
            }
        }
        long durationInMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startTime);  // Total execution time in milliseconds
        return problemNr + "\t\t" + (durationInMillis + "        ").substring(0, 9) + "\t" + solution;
    }

    private static void init() {
        try {
            EulerProperties mediaProperties = new EulerProperties();
        } catch (IOException e) {
            System.err.println("Error initializing EulerProperties: " + e.getMessage());
        }
    }
}
