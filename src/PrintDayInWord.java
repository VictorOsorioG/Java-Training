public class PrintDayInWord {
    public static void main(String[] args) {
        System.out.println("Switch \n");
        switchDayInWord(0);
        switchDayInWord(1);
        switchDayInWord(2);
        switchDayInWord(3);
        switchDayInWord(4);
        switchDayInWord(5);
        switchDayInWord(6);
        switchDayInWord(7);
        System.out.println("\nIf \n");
        ifDayInWord(0);
        ifDayInWord(1);
        ifDayInWord(2);
        ifDayInWord(3);
        ifDayInWord(4);
        ifDayInWord(5);
        ifDayInWord(6);
        ifDayInWord(7);
    }

    private static void ifDayInWord(int number) {
        if(number == 0) {
            System.out.println("Sunday");
        } else if (number == 1) {
            System.out.println("Monday");
        } else if (number == 2) {
            System.out.println("Tuesday");
        } else if (number == 3) {
            System.out.println("Wednesday");
        } else if (number == 4) {
            System.out.println("Thursday");
        } else if (number == 5) {
            System.out.println("Friday");
        } else if (number == 6) {
            System.out.println("Saturday");
        } else {
            System.out.println("Not a valid day");
        }
    }

    private static void switchDayInWord(int number) {
        switch (number) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Not a valid day");
                break;
        }
    }
}
