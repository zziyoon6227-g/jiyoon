import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GradeDAO {

    // 성적 입력
    public void insertGrade(Grade grade) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "INSERT INTO grade (stu_id, stu_name, kor, eng, math, teacher_note) " +
                    "VALUES(grade_seq.NEXTVAL, ?, ?, ?, ?, NULL)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, grade.getStuName());
            pstmt.setInt(2, grade.getKor());
            pstmt.setInt(3, grade.getEng());
            pstmt.setInt(4, grade.getMath());

            int rows = pstmt.executeUpdate();

            System.out.println("저장된 행 수: " + rows);
            System.out.println("DB 저장 성공! [" + grade.getStuName() + "] 학생 데이터가 저장되었습니다.");

        } catch (Exception e) {
            System.out.println("성적 저장 실패");
            e.printStackTrace();

        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 성적 수정
    public void updateGrade(String name, int kor, int eng, int math) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "UPDATE grade SET kor = ?, eng = ?, math = ? WHERE stu_name = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, kor);
            pstmt.setInt(2, eng);
            pstmt.setInt(3, math);
            pstmt.setString(4, name);

            int rows = pstmt.executeUpdate();

            if (rows > 0) System.out.println("성적 수정 완료");
            else System.out.println("해당 학생이 없습니다.");

        } catch (Exception e) {
            System.out.println("성적 수정 실패");
            e.printStackTrace();

        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 코멘트 입력
    public void updateNote(String name, String note) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "UPDATE grade SET teacher_note = ? WHERE stu_name = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, note);
            pstmt.setString(2, name);

            int rows = pstmt.executeUpdate();

            if (rows > 0) System.out.println("코멘트 저장 완료");
            else System.out.println("해당 학생이 없습니다.");

        } catch (Exception e) {
            System.out.println("코멘트 저장 실패");
            e.printStackTrace();

        } finally {
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 학급 리포트
    public void ClassReport() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "SELECT stu_name, " +
                    "kor + eng + math AS total, " +
                    "ROUND((kor + eng + math) / 3, 1) AS avg_score, " +
                    "RANK() OVER (ORDER BY (kor + eng + math) DESC) AS ranking " +
                    "FROM grade ORDER BY ranking";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("\n--- 학급 리포트 ---");

            printStudentList();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("ranking") + "위 " +
                        rs.getString("stu_name") +
                        " / 총점: " + rs.getInt("total") +
                        " / 평균: " + rs.getDouble("avg_score")
                );
            }

            Summary();

        } catch (Exception e) {
            System.out.println("학급 리포트 조회 실패");
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 학생 목록
    public void printStudentList() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "SELECT LISTAGG(stu_name, ', ') WITHIN GROUP (ORDER BY stu_name) AS student_list FROM grade";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("전체 학생 목록: " + rs.getString("student_list"));
            }

        } catch (Exception e) {
            System.out.println("학생 목록 조회 실패");
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 통계
    public void Summary() {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "SELECT " +
                    "ROUND(AVG((kor + eng + math) / 3), 1) AS class_avg, " +
                    "MAX(kor + eng + math) AS max_total, " +
                    "MIN(kor + eng + math) AS min_total " +
                    "FROM grade";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("\n전체 평균: " + rs.getDouble("class_avg"));
                System.out.println("최고 총점: " + rs.getInt("max_total"));
                System.out.println("최저 총점: " + rs.getInt("min_total"));
            }

        } catch (Exception e) {
            System.out.println("학급 통계 조회 실패");
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    // 학생 조회
    public void searchStudent(String name) {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = GradeConnection.getConnection();

            String sql =
                    "SELECT * FROM ( " +
                    "SELECT stu_name, kor, eng, math, teacher_note, " +
                    "kor + eng + math AS total, " +
                    "ROUND((kor + eng + math) / 3, 1) AS avg_score, " +
                    "RANK() OVER (ORDER BY (kor + eng + math) DESC) AS ranking " +
                    "FROM grade) WHERE stu_name = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                System.out.println("\n--- 학생 성적 조회 ---");
                System.out.println("이름: " + rs.getString("stu_name"));
                System.out.println("국어: " + rs.getInt("kor"));
                System.out.println("영어: " + rs.getInt("eng"));
                System.out.println("수학: " + rs.getInt("math"));
                System.out.println("총점: " + rs.getInt("total"));
                System.out.println("평균: " + rs.getDouble("avg_score"));
                System.out.println("석차: " + rs.getInt("ranking") + "위");
                System.out.println("성취도: " + getGrade(rs.getDouble("avg_score")));
                System.out.println("코멘트: " + rs.getString("teacher_note"));

            } else {
                System.out.println("조회 결과 없음");
            }

        } catch (Exception e) {
            System.out.println("학생 조회 실패");
            e.printStackTrace();

        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }


    public String getGrade(double avg) {

        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
}