public class BitShift {
    public static void main(String[] args) {
        int n1 = 1;
        int result1 = n1 << 3;
        int result2 = n1 * (int) Math.pow(2,3);
        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);

        int n2 = -8;
        int result3 = n2 >> 3;
        int result4 = n1 / (int) Math.pow(2,3);
        System.out.println("result3: " + result3);
        System.out.println("result4: " + result4);

    }
}
