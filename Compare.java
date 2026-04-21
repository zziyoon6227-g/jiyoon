public class Compare {
    public static void main(String[] args) {
        
        int n1 = 10;
        int n2 = 10;

        boolean result1 = (n1 == n2);
        boolean result2 = (n1 != n2);
        boolean result3 = (n1 <= n2);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);

        char char1 = 'A';
        char char2 = 'B';
        boolean result4 = (char1 < char2);
        System.out.println("result4: " + result4);

        int n3 = 1;
        double n4 = 1.0;
        boolean result5 = (n3 == n4);
        System.out.println("result5: " + result5);

        float n5 = 0.1f;
        double n6 = 0.1;
        boolean result6 = ( n5 == n6);
        boolean result7 = (n5 == (float)n6);

        System.out.println("result6: " + result6);
        System.out.println("result7: " + result7);

        String str1 = "자바";
        String str2 = "Java";

        boolean result8 = (str1.equals(str2));
        boolean result9 = (! str1.equals(str2));
        
        System.out.println("result8: " + result8);
        System.out.println("result9: " + result9);
    }
    
}
