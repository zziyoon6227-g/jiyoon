import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDAO {
    
    public void insertMember(int id, int pw, String name){

        try{
            Connection conn = ConnectionFactory.getConnection();

            String sql = "" +
            "INSERT INTO TBL_MEMBER VALUES(?, ?, ?, SYSDATE)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setInt(2,pw);
            pstmt.setString(3,name);

            int rows = pstmt.executeUpdate();
                System.out.println("저장된 행 수: " + rows);

                pstmt.close();
                conn.close();
        }
        catch(Exception e){
            System.out.println("회원 추가 실패");
            e.printStackTrace();
        }

    }
        public void deleteMember(int id, int pw){
            try{
                Connection conn = ConnectionFactory.getConnection();
    
                String sql = "DELETE FROM TBL_MEMBER WHERE ID=? and PW=?";  

                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setInt(2,pw);
    
                int rows = pstmt.executeUpdate();
                System.out.println("삭제된 행 수: " + rows); 
    
                    pstmt.close();
                    conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
    }
}
