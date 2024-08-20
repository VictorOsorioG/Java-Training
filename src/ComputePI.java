public class ComputePI {

    public static void main(String[] args) {

        System.out.println("PI with 1000 is: " + compute(1000));
        System.out.println("PI with 10000 is: " + compute(10000));
        System.out.println("PI with 100000 is: " + compute(100000));
        System.out.println("PI with 1000000 is: " + compute(1000000));
    }

    private static double compute(int maxDenominator) {
        double sum = 0.0;
        for (int denominator = 1; denominator <= maxDenominator; denominator += 2) {
            if (denominator % 4 == 1) {
                sum += 1.0 / denominator;
            } else if (denominator % 4 == 3) {
                sum -= 1.0 / denominator;
            } else {
                System.out.println("Impossible!!!");
            }
        }
        return 4.0 * sum;
    }
}
