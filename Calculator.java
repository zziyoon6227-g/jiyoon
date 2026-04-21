public class Calculator { //라이브러리 클래스
    //메소드
    void powerOn(){
        System.out.println("전원을 켭니다.");
    }

    int plus(int x, int y){
        int result = x + y;
        return result;
    }

    double divide(int x, int y){ //byte형보다 크니까 값 받을 수 있음
        double result = (double)x/(double)y;  //하나만 캐스트연산해도됨,캐스트연산먼저
        return result;
    }
    
    void powerOff(){
        System.out.println("전원을 끕니다.");
    }
}
