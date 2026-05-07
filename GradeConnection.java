import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GradeConnection {
    public static Connection getConnection(){ 
        Connection conn = null;
        try{
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "System",
                "1234"
                );

            System.out.println("DB 연결 성공");

        }catch(ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("드라이버 오류");
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("DB 연결 실패");
        }
    
        return conn;
    }
}
