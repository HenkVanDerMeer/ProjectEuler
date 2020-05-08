package service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class EulerUtils {

    // Get smallest prime numbers that make a product of BigInteger number
    public static List<Long> getPrimes(BigInteger number) {

        List<Long> primes = new ArrayList<>();
        BigInteger div = getPrime(number);
        while(!number.equals(getPrime(number))) {
            primes.add(div.longValue());
            number = number.divide(div);
            div = getPrime(number);
        }
        primes.add(div.longValue());
        return primes;
    }

    // Get smallest prime number of BigInteger value
    private static BigInteger getPrime(BigInteger value) {
        BigInteger div = BigInteger.valueOf(2);
        while(true) {
            if(value.divideAndRemainder(div)[1].equals(BigInteger.ZERO)) {
                return div;
            } else {
                div = div.add(BigInteger.ONE);
            }
        }
    }

    // Get largest number which, multiplied by a smaller number and then reversed, equals the same number
    public static int getLargestPalindrome(int number) {
        for(int i = number; i >= 0; i--) {
            if(number * i == reverseNumber(number * i)) {
                return i;
            }
        }
        // No number found
        return 0;
    }

    // Reserve number by digits
    private static int reverseNumber(int number) {
        StringBuilder reverse = new StringBuilder();
        String sNumber = String.valueOf(number);
        for(int i = sNumber.length() - 1; i >= 0; i--) {
            reverse.append(sNumber.charAt(i));
        }
        return Integer.parseInt(reverse.toString());
    }

    // Is value divisible by all number from 1 to divider
    public static boolean isDivisible(int value, int divider) {
        boolean divisible = true;
        for (int i = 1; i <= divider; i++) {
            if (!(value % i == 0)) {
                divisible = false;
                break;
            }
        }
        return divisible;
    }

    // Get the product of all distinct digits of String s
    public static BigInteger getProduct(String s) {
        BigInteger product = BigInteger.valueOf(Long.parseLong(s.substring(0, 1)));
        for (int i = 1; i < s.length(); i++) {
            product = product.multiply(BigInteger.valueOf(Long.parseLong((s.substring(i, i + 1)))));
        }
        return product;
    }
}
