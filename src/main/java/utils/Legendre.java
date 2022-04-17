package utils;

import java.math.BigInteger;

public class Legendre {

    public static BigInteger getSymbol(BigInteger a, BigInteger p) {
        if (a.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        if (a.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            BigInteger degree = p.pow(2).subtract(BigInteger.ONE).divide(BigInteger.valueOf(8));
            return getSymbol(a.divide(BigInteger.valueOf(2)), p).multiply((degree.mod(BigInteger.valueOf(2))
                    .equals(BigInteger.ZERO) ? BigInteger.ONE : BigInteger.valueOf(-1)));
        } else if (!a.equals(BigInteger.ONE)){
            BigInteger degree = a.subtract(BigInteger.ONE)
                    .multiply(p.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(4));
            return getSymbol(p.mod(a), a).multiply((degree.mod(BigInteger.valueOf(2))
                    .equals(BigInteger.ZERO) ? BigInteger.ONE : BigInteger.valueOf(-1)));
        }
        return null;
    }

    /*public static int getSymbol(BigInteger a, BigInteger n) {
        if (a.compareTo(BigInteger.ZERO) < 0 || n.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Число n - четное: " + n);
        }
        a = a.remainder(n);
        int jacobi = 1;
        while (a.compareTo(BigInteger.ZERO) > 0) {
            while (a.remainder(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                a = a.divide(BigInteger.valueOf(2));
                BigInteger r = n.remainder(BigInteger.valueOf(8));
                if (r.equals(BigInteger.valueOf(3))) {
                    jacobi = -jacobi;
                }
            }
            BigInteger temp = n;
            n = a;
            a = temp;
            if (a.remainder(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) &&
                    n.remainder(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) ) {
                jacobi = -jacobi;
            }
            a = a.remainder(n);
        }
        if (n.equals(BigInteger.ONE)) {
            return jacobi;
        }
        return 0;
    }*/
}