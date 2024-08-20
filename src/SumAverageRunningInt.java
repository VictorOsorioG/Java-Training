import java.util.stream.IntStream;

public class SumAverageRunningInt {
    public static void main(String[] args) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;

        int sum = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .sum();

        int totalNumbers = UPPER_BOUND - LOWER_BOUND + 1;

        double avg = (double) sum/totalNumbers;

        System.out.println("The sum of " + LOWER_BOUND + " to " + UPPER_BOUND + " is " + sum);
        System.out.println("The average is " + avg);
    }
}
