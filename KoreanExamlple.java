public class KoreanExamlple {
    public static void main(String[] args) {
        
        Korean k1 = new Korean("한국","박자바", "011225-1234567"); 
        System.out.println("k1.nation: " +k1.nation);
        System.out.println("k1.name: " +k1.name);
        System.out.println("k1.ssn: "+k1.ssn);
        //ex) k1은 0x10번지, nation은 바뀌지 않음(명시적필드초기화라)

        Korean k2 = new Korean("중국","김자바", "930525-0654321");
        System.out.println("k1.nation: " +k2.nation);
        System.out.println("k2.name: " +k2.name);
        System.out.println("k2.ssn: "+k2.ssn);
         //ex) k2은 0x1500번지
    }
}
