package utils;

import java.math.BigInteger;

public class Legendre {

    public static int getSymbol(BigInteger k, BigInteger n) {
        if (k.compareTo(BigInteger.ZERO) < 0 || n.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Число n - четное: " + n);
        }
        k = k.remainder(n);
        int jacobi = 1;
        while (k.compareTo(BigInteger.ZERO) > 0) {
            while (k.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                k = k.divide(BigInteger.valueOf(2));
                BigInteger r = n.remainder(BigInteger.valueOf(8));
                if (r.equals(BigInteger.valueOf(3))) {
                    jacobi = -jacobi;
                }
            }
            BigInteger temp = n;
            n = k;
            k = temp;
            if (k.remainder(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) &&
                    n.remainder(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) ) {
                jacobi = -jacobi;
            }
            k = k.remainder(n);
        }
        if (n.equals(BigInteger.ONE)) {
            return jacobi;
        }
        return 0;
    }
}