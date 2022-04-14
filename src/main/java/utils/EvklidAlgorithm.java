package utils;

import java.math.BigInteger;
import java.util.Random;

public class EvklidAlgorithm {
    public static BigInteger gcd(BigInteger a, BigInteger b) {
        while (!b.equals(BigInteger.ZERO)) {
            BigInteger tmp = a.mod(b);
            a = b;
            b = tmp;
        }
        return a;
    }

    public static BigInteger nextRandomBigInteger(BigInteger n) {
        Random rand = new Random();
        BigInteger result = new BigInteger(n.bitLength(), rand);
        while( result.compareTo(n) >= 0 ) {
            result = new BigInteger(n.bitLength(), rand);
        }
        return result;
    }
}
