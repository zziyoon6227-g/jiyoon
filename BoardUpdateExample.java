import java.io.FileInputStream;
import java.lang.Thread.Builder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardUpdateExample {
    public static void main(String[] args) {
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "System",
                "1234"
                );

                String sql = new StringBuilder()
                .append("UPDATE boards SET ")  //BOARDS 테이블을 업데이트 하겠다
                .append("btitle=?, ")
                .append("bcontent=?, ")
                .append("bfilename=?, ")
                .append("bfiledata=? ")
                .append("WHERE bno=? ")  //게시글 번호
                .toString();

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"눈싸람");
                pstmt.setString(2,"눈으로 만든 사람이다.");
                pstmt.setString(3,"snowman.jpg");
                pstmt.setBlob(4, new FileInputStream("C:/javame/jiyoon1/src/snowman.jpg"));
                pstmt.setInt(5, 1); //앞번호는 물음표 위치, 뒤에는 업데이트 할 게시글 번호
               


                int rows = pstmt.executeUpdate();
                System.out.println("수정된 행 수: " + rows); 
                pstmt.close();
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                if(conn!=null){
                    try{
                        conn.close();
                    }catch(SQLException e){}
                }
            }
        }
    }
