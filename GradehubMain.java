import java.util.Scanner;

public class GradehubMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeDAO dao = new GradeDAO();

        while (true) {
            System.out.println("\n==== Grade Hub ====");
            System.out.println("1. 교사 모드");
            System.out.println("2. 학생 모드");
            System.out.println("0. 종료");
            System.out.print("선택 >> ");

            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                teacherMode(sc, dao);
            } else if (menu == 2) {
                studentMode(sc, dao);
            } else if (menu == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }

        sc.close();
    }

    public static void teacherMode(Scanner sc, GradeDAO dao) {

        while (true) {
            System.out.println("\n--- 교사 모드 ---");
            System.out.println("1. 성적 입력");
            System.out.println("2. 성적 수정");
            System.out.println("3. 코멘트 입력");
            System.out.println("4. 학급 리포트");
            System.out.println("0. 이전 메뉴");
            System.out.print("선택 >> ");

            int menu = Integer.parseInt(sc.nextLine());

            if (menu == 1) {
                System.out.print("성적 입력(이름,국어,영어,수학): ");
                String input = sc.nextLine();

                String[] arr = input.split(",");

                String name = arr[0].trim();
                int kor = Integer.parseInt(arr[1].trim());
                int eng = Integer.parseInt(arr[2].trim());
                int math = Integer.parseInt(arr[3].trim());

                Grade grade = new Grade(name, kor, eng, math);
                dao.insertGrade(grade);

            } else if (menu == 2) {
                System.out.print("수정할 학생 이름: ");
                String name = sc.nextLine();

                System.out.print("국어 점수: ");
                int kor = Integer.parseInt(sc.nextLine());

                System.out.print("영어 점수: ");
                int eng = Integer.parseInt(sc.nextLine());

                System.out.print("수학 점수: ");
                int math = Integer.parseInt(sc.nextLine());

                dao.updateGrade(name, kor, eng, math);

            } else if (menu == 3) {
                System.out.print("코멘트 입력할 학생 이름: ");
                String name = sc.nextLine();

                System.out.print("선생님 코멘트: ");
                String note = sc.nextLine();

                dao.updateNote(name, note);

            } else if (menu == 4) {
                dao.ClassReport();

            } else if (menu == 0) {
                break;

            } else {
                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }

    public static void studentMode(Scanner sc, GradeDAO dao) {
        System.out.println("\n--- 학생 모드 ---");
        System.out.print("본인 이름을 입력하세요: ");

        String name = sc.nextLine();

        dao.searchStudent(name);
    }
}