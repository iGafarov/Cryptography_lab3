import utils.EvklidAlgorithm;
import utils.Legendre;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static BigInteger n;
    private static BigInteger a = BigInteger.ZERO;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextBigInteger();
        int counter = 0;
        int composite = 0;
        List<BigInteger> aValues = new ArrayList<>();
        while (counter < 16) {
            System.out.println("Итерация: " + counter);
            while (aValues.contains(a)) {
                a = EvklidAlgorithm.nextRandomBigInteger(n);
            }
            if (!testCompositeByEvklid()) {
                System.out.println("1.Число n: " + n + " составное");
                ++composite;
            }
            if (!testEquivalence()) {
                System.out.println("2.Число n: " + n + " составное");
                ++composite;
            }
            ++counter;
            aValues.add(a);
        }
        System.out.println("Composite count: " + composite);
    }

    private static boolean testCompositeByEvklid() {
        return EvklidAlgorithm.gcd(a, n).equals(BigInteger.ONE);
    }

    private static boolean testEquivalence() {
        BigInteger degree = (n.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2));
        BigInteger tmp = a.modPow(degree, n);
        int legendre = Legendre.getSymbol(a, n);
        return tmp.equals(BigInteger.valueOf(legendre));
    }

}
