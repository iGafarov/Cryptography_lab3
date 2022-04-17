import utils.EvklidAlgorithm;
import utils.Legendre;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static BigInteger n;
    private static BigInteger a;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextBigInteger();
        int counter = 0;
        int composite = 0;
        List<BigInteger> aValues = new ArrayList<>();
        while (counter < 10) {
            System.out.println("Итерация: " + counter);
            a = EvklidAlgorithm.nextRandomBigInteger(n);
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
        int[] symbols = {-1, 0, -1};
        BigInteger degree = (n.subtract(BigInteger.ONE)).divide(BigInteger.valueOf(2));
        BigInteger tmp = a.modPow(degree, n);
        BigInteger legendre = Legendre.getSymbol(a, n);
        if (tmp.equals(legendre) || (n.add(legendre).equals(tmp) && legendre.equals(BigInteger.valueOf(-1)))) {
            return true;
        } else {
            return false;
        }
    }

}
