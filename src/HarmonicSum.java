import java.util.stream.DoubleStream;

public class HarmonicSum {
    public static void main(String[] args) {

        final int MAX_DENOMINATOR = 50000;

        double sumL2R = DoubleStream
                .iterate(1.0, denominator -> denominator + 1.0)
                .limit(MAX_DENOMINATOR)
                .map(denominator -> 1.0 / denominator)
                .sum();

        double sumR2L = DoubleStream
                .iterate(MAX_DENOMINATOR, denominator -> denominator - 1.0)
                .limit(MAX_DENOMINATOR)
                .map(denominator -> 1.0 / denominator)
                .sum();

        System.out.println("The sum from left to right is: " + sumL2R);
        System.out.println("The sum from right to left is: " + sumR2L);
        System.out.println("The absolute difference is: " + Math.abs(sumL2R - sumR2L));

        System.out.println("Without streams the results are different");

        sumL2R = 0.0;
        sumR2L = 0.0;

        for (int denominator = 1; denominator <= MAX_DENOMINATOR; denominator++) {
            sumL2R += 1.0/denominator;
        }

        for (int denominator = MAX_DENOMINATOR; denominator >= 1; denominator--) {
            sumR2L += 1.0/denominator;
        }

        System.out.println("The sum from left to right is: " + sumL2R);
        System.out.println("The sum from right to left is: " + sumR2L);
        System.out.println("The absolute difference is: " + Math.abs(sumL2R - sumR2L));
    }
}
