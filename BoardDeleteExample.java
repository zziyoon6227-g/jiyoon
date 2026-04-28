import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardDeleteExample {
    public static void main(String[] args) {
        Connection conn = null;

        try{
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "System",
                "1234"
                );

                String sql = "DELETE FROM boards WHERE bwriter=?";  //BOARDS 테이블에서 winter가 쓴글 삭제

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,"winter");

                int rows = pstmt.executeUpdate();
                System.out.println("삭제된 행 수: " + rows); 

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