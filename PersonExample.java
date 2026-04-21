public class PersonExample {
    public static void main(String[] args) {
        
        Person p1 =new Person("123456-1234567", "계백");

        System.out.println(p1.nation);
        System.out.println(p1.ssn);
        System.out.println(p1.name);

        //p1.nation = "USA";   변경되지 않음  final
       // p1.ssn = "646221-15151";  변경되지 않음
        p1.name = "을지문덕";
        System.out.println(p1.name); //바꾸고나서 출력 누르면 name의 변경된 값 을지문덕이 보임
    }
}
