public class Test4 {
    public static void main(String[] args) {
        
    String f = "사과";

    switch(f) {
    case "사과" -> System.out.println("1,000원");
    case "바나나" -> System.out.println("2,000원");
    case "포도" -> System.out.println("5,000원");
    default -> System.out.println("판매하지 않는 과일입니다.");
}
}
}

