package folder1; //패키지는 1행에 무조건

public class A {
    
    public int field1;
    int field2;
    private int field3;

    public A(){
        field1 = 1;
        field2 = 1;
        field3 = 1;

        method1();
        method2();
        method3();
        //System.out.println("생성자로 객체가 생성되었습니다.");
    }

    public void method1(){}
    void method2 (){}
    private void method3(){}
}
//라이브러리 클래스라 실행이 안됨, 활용클래스 따로 만들어야함