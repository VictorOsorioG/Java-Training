import java.util.stream.IntStream;

public class Product1ToN {
    public static void main(String[] args) {

        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 10;

        int factorial = IntStream.rangeClosed(LOWER_BOUND, UPPER_BOUND)
                .reduce(1, (a,b) -> a * b);

        System.out.println("The factorial of " + UPPER_BOUND + " is " + factorial);
    }
}
