package folder1;

public class B {
    public B(){
     A a = new A();
     a.field1 = 1; //public이라 다 호출 가능
     a.field2 = 1; //default는 같은 패키지 안 호출 가능

     a.method1();
     a.method2();
}
}
//라이브러리 클래스라 실행이 안됨, 활용클래스 따로 만들어야함
