public class Test5 {
    
    public static void main(String[] args) {
        
        String d = "콜라";

        switch(d){
            case "콜라","사이다":
            System.out.println("탄산음료가 나옵니다.");
            break;

            case "커피":
            case "아이스커피":
            System.out.println("아메리카노가 나옵니다.");
            break;

            case "물":
            System.out.println("시원한 생수가 나옵니다.");
            break;

            default:
            System.out.println("해당 번호의 음료가 없습니다.");
        }
    }
}
