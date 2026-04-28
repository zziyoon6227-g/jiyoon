import java.io.FileInputStream;
import java.lang.Thread.Builder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserUpdateExample {
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
                .append("UPDATE users SET ")
                .append("username=?, ")
                .append("userpassword=?, ")
                .append("userage=?, ")
                .append("usermail=? ")
                .append("WHERE userid=?")
                .toString();

                PreparedStatement pstmt = conn.prepareStatement(sql);

                pstmt.setString(1,"한여름");
                pstmt.setString(2,"2026");
                pstmt.setInt(3,30);
                pstmt.setString(4,"summer@mycompany.com");
                pstmt.setString(5,"winter2");


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

