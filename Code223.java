import java.io.FileOutputStream;
import java.io.IOException;

public class Code223 {
    public static void main(String[] args) {
        String content = "Hello Java Program"; //출력결과가 data4.txt에 나옴
        byte[] bytes = content.getBytes();
        FileOutputStream fos = null;

        try{
            fos = new FileOutputStream("C:/javame/jiyoon1/src/data4.txt"); //한글쓸때 깨질수있음 파일아웃풋스트림은 그래서 FileWriter로 하면 됨, 바이트 단위임
            fos.write(bytes);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            try{
                fos.close();
            }
            catch(IOException e){
                System.out.println(e);
            }
        }
    }
    
}
