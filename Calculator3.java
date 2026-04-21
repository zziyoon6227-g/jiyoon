public class Calculator3 { //메소드 오버로딩: 클래스 내 같은 이름 메소드 여러 개 선언
    
    int plus(int x, int y){
        return x+y;
    }

    double plus(double x, int y){
            return x+y;
        }

    double plus(double x, double y){
            return x+y;
        }

    double plus(int x, double y){
            return x+y;
        }
}
