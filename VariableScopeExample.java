public class VariableScopeExample {
    public static void main(String[] args) { //main 치면 자동으로 
        int v1 = 15;
        if(v1>10){
            int v2;
            v2 = v1 - 10;
            
        }
        int v2 = 3;
        int v3 = v1 + v2 + 5;
        System.out.println(v2); //v2를 사용하려면 다시 선언 아니면 if문 밖에서 선언
        

    }
}
