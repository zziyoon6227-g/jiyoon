public class StudentExample {
     public static void main(String[] args) {
        
        Student s1 = new Student();
        System.out.println(s1); //s1은 참조변수

        Student s2 = new Student();
        System.out.println("s2 변수가 또 다른 Student 객체를 참조합니다");
     }
}

//StudentExample 이 공간은 활용클래스, Student는 라이브러리에 있는 클래스