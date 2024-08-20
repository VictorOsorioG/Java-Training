import java.util.stream.IntStream;

public class Fibonacci {
    public static void main(String[] args) {

        final int N_MAX = 20;
        int fnMinus1 = 1;
        int fnMinus2 = 1;
        int sum = fnMinus1 + fnMinus2;
        int fn;

        System.out.println("The first " + N_MAX + " Fibonacci numbers are:");
        System.out.print(fnMinus1 + " " + fnMinus2 + " ");

        for (int n = 3; n <= N_MAX; n++) {
            fn = fnMinus1 + fnMinus2;
            System.out.print(fn + " ");

            sum += fn;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }

        double avg = (double) sum / N_MAX;
        System.out.println("\nThe average is " + avg);
    }
}
