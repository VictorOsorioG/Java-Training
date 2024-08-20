public class CheckOddEven {
    public static void main(String[] args) {
        checkNumber(0);
        checkNumber(1);
        checkNumber(88);
        checkNumber(99);
        checkNumber(-1);
        checkNumber(-2);
    }

    private static void checkNumber(int number) {
        if ((number % 2) == 0) {
            System.out.println("Even Number");
        } else {
            System.out.println("Odd Number");
        }
        System.out.println("bye! \n");
    }
}
