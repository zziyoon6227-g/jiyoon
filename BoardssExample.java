import java.sql.*;
import java.util.Scanner;

public class BoardssExample {

    private Connection conn;
    private Scanner sc = new Scanner(System.in);

    // =========================
    // main (프로그램 시작)
    // =========================
    public static void main(String[] args) {
        BoardssExample be = new BoardssExample();
        be.menu();
    }

    // =========================
    // 생성자 (DB 연결)
    // =========================
    public BoardssExample() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "System",
                    "1234"
            );

            System.out.println("DB 연결 성공");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 1. 목록 (READ LIST)
    // =========================
    public void list() {

        System.out.println("\n[게시글 목록]");
        System.out.println("번호\t제목\t작성자\t날짜");

        String sql =
                "SELECT bno, btitle, bwriter, " +
                "TO_CHAR(bdate,'YYYY-MM-DD') bdate " +
                "FROM boardss ORDER BY bno DESC";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Boardss b = new Boardss();
                b.setBno(rs.getInt("bno"));
                b.setBtitle(rs.getString("btitle"));
                b.setBwriter(rs.getString("bwriter"));
                b.setBdate(rs.getString("bdate"));

                System.out.println(b);
            }

            rs.close();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 2. 등록 (CREATE)
    // =========================
    public void create() {

        System.out.println("\n[게시글 등록]");

        System.out.print("제목: ");
        String title = sc.nextLine();

        System.out.print("내용: ");
        String content = sc.nextLine();

        System.out.print("작성자: ");
        String writer = sc.nextLine();

        String sql =
                "INSERT INTO boardss (bno, btitle, bcontent, bwriter) " +
                "VALUES (boardss_seq.NEXTVAL, ?, ?, ?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, writer);

            int rows = pstmt.executeUpdate();

            System.out.println("등록 성공: " + rows);

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 3. 상세보기 (READ ONE)
    // =========================
    public void read() {

        System.out.print("\n게시글 번호: ");
        int bno = Integer.parseInt(sc.nextLine());

        String sql =
                "SELECT bno, btitle, bcontent, bwriter, " +
                "TO_CHAR(bdate,'YYYY-MM-DD') bdate " +
                "FROM boardss WHERE bno=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bno);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                System.out.println("\n번호: " + rs.getInt("bno"));
                System.out.println("제목: " + rs.getString("btitle"));
                System.out.println("내용: " + rs.getString("bcontent"));
                System.out.println("작성자: " + rs.getString("bwriter"));
                System.out.println("날짜: " + rs.getString("bdate"));

                System.out.println("\n1.수정 2.삭제 3.뒤로");
                String menu = sc.nextLine();

                if (menu.equals("1")) {
                    update(bno);
                } else if (menu.equals("2")) {
                    delete(bno);
                }

            } else {
                System.out.println("게시글 없음");
            }

            rs.close();
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 4. 수정 (UPDATE)
    // =========================
    public void update(int bno) {

        System.out.println("\n[수정]");

        System.out.print("제목: ");
        String title = sc.nextLine();

        System.out.print("내용: ");
        String content = sc.nextLine();

        String sql =
                "UPDATE boardss SET btitle=?, bcontent=? WHERE bno=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, bno);

            int rows = pstmt.executeUpdate();

            System.out.println("수정 완료: " + rows);

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 5. 삭제 (DELETE)
    // =========================
    public void delete(int bno) {

        String sql = "DELETE FROM boardss WHERE bno=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, bno);

            int rows = pstmt.executeUpdate();

            System.out.println("삭제 완료: " + rows);

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 6. 전체 삭제
    // =========================
    public void clear() {

        String sql = "DELETE FROM boardss";

        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);

            int rows = pstmt.executeUpdate();

            System.out.println("전체 삭제: " + rows);

            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // =========================
    // 7. 메뉴 실행
    // =========================
    public void menu() {

        while (true) {

            list();

            System.out.println("\n1.Create 2.Read 3.Clear 4.Exit");
            System.out.print("선택하세요 >>> ");

            String menu = sc.nextLine();

            switch (menu) {
                case "1" -> create();
                case "2" -> read();
                case "3" -> clear();
                case "4" -> {
                    System.out.println("종료되었습니다.");
                    return;
                }
            }
        }
    }
}