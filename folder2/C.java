package folder2;

import folder1.A; //패키지 폴더1에서 A클래스를 import하겠다.

public class C {
    public C(){
        A a = new A();
        a.field1 = 1;

        a.method1(); //필드1만 가능 필드2는 패키지가 다르고, 필드3는 클래스가 달라서
    }
}
//라이브러리 클래스라 실행이 안됨, 활용클래스 따로 만들어야함