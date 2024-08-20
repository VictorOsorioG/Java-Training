
public class CozaLozaWoza {
    public static void main(String[] args) {
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 110;
        boolean printed = false;

        for (int number = LOWER_BOUND; number <= UPPER_BOUND; number++) {
            if (number % 3 == 0) {
                System.out.print("Coza");
                printed = true;
            }

            if (number % 5 == 0) {
                System.out.print("Loza");
                printed = true;
            }

            if (number % 7 == 0) {
                System.out.print("Woza");
                printed = true;
            }

            if (!printed) {
                System.out.print(number);
            }

            if (number % 11 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
            printed = false;
        }

    }
}
