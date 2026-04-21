import java.util.Scanner;

public class Dowhile {
    public static void main(String[] args) {
        System.out.println("메시지 입력");
        System.out.println("종료시 q를 입력");

        Scanner scanner = new Scanner(System.in);
        String inputString;

        do{ 
            System.out.print(">");
            inputString = scanner.nextLine(); //영문만 나옴 한글은 안나옴
            System.out.println(inputString);
        } while( ! inputString.equals("q"));

        System.out.println();
        System.out.println("프로그램 종료");
    }
}
