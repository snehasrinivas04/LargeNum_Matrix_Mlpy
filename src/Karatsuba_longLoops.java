import java.util.Scanner;
public class Karatsuba_longLoops {

    public static void main(String[] args) {
        long x, y;
        System.out.println("Enter two integer numbers\n");
        try (Scanner s = new Scanner(System.in)) {
            x = s.nextLong();
            y = s.nextLong();
        }
        long result = karatsuba(x, y);
        System.out.println(result);
    }

    private static long karatsuba(long x, long y) {
        if (x <= 15 && y <= 15)
            return x * y;

        int n = Math.max(Long.valueOf(x).toString().length(), (Long.valueOf(y).toString().length()));
        int m = n / 2 + n % 2;

        long a = x / (long) Math.pow(10, m);
        long b = x % (long) Math.pow(10, m);
        long c = y / (long) Math.pow(10, m);
        long d = y % (long) Math.pow(10, m);
        long S1 = karatsuba(a, c);
        long S2 = karatsuba(b, d);
        long S3 = karatsuba(a + b, c + d);
        long S4 = S3 - S2 - S1;
        long S5 = S1 * (long) Math.pow(10, m * 2) + S2 + S4 * (long) Math.pow(10, m);
        return S5;
    }

}