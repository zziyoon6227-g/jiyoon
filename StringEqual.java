public class StringEqual {
    public static void main(String[] args) {
        String strvar1 = "신민철";  //strvar1,2 주소지가 0x10번지로 같음
        String strvar2 = "신민철";
        String strvar3 = new String ("신민철");

        System.out.println( strvar1 == strvar2);
        System.out.println( strvar1 == strvar3);
        System.out.println();
        System.out.println( strvar1.equals(strvar2));
        System.out.println( strvar1.equals(strvar3));
    }
}
