public class Accuracy {
    public static void main(String[] args) {
        
        int apple = 1;

        int total = apple*10;
        int n = 7;
        int temp =  total - n;

        double result = temp/10.0;

        System.out.println("사과 한개에서");
        System.out.println("0.7 조각을 빼면,");
        System.out.println(result + "조각이 남는다.");

        //double 오류나서 정수로 바꿔서 계산해줌
    }
}
