public class CheckPassFail {
    public static void main(String[] args) {
        checkMark(0);
        checkMark(49);
        checkMark(50);
        checkMark(51);
        checkMark(100);
    }

    private static void checkMark(int mark) {
        if (mark >= 50) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
        System.out.println("DONE \n");
    }
}
