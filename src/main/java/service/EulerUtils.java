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
}
